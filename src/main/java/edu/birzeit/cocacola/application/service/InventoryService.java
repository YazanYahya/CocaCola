package edu.birzeit.cocacola.application.service;


import edu.birzeit.cocacola.application.model.Inventory;
import edu.birzeit.cocacola.application.model.Product;
import edu.birzeit.cocacola.application.repository.InventoryRepository;
import edu.birzeit.cocacola.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;


    public Inventory getInventoryById(int id) {
        return this.inventoryRepository.findById(id);
    }

    public List<Inventory> getInventory() {
        List<Inventory> inventory = new ArrayList<>();
        inventoryRepository.findAll().forEach(inventory::add);
        return inventory;
    }


    public Inventory addProductInventory(Inventory inventory, int product_id) {
        if (this.productRepository.findById(product_id) == null)
            return null;
        else {
            inventory.setProducts(new Product(product_id));
            return inventoryRepository.save(inventory);
        }
    }


    public Inventory getInventory(int product_id) {
        return inventoryRepository.findByProduct_id(product_id);
    }


    public Inventory getInventoryByQrcode(String qrcode) {
        Product p = getProductByQrcode(qrcode);
        if (p == null)
            return null;
        int prodductid = p.getId();
        return getInventory(prodductid);
    }


    public Product getProductByQrcode(String qrcode) {
        return productRepository.findByQrcode(qrcode);
    }


    public Inventory increaseProductQuantity(String qrcode, Inventory inv) {
        Product p = getProductByQrcode(qrcode);
        if (p == null)
            return null;

        int productid = p.getId();
        Inventory inventory = getInventory(productid);
        inventory.setQuantity(inventory.getQuantity() + inv.getQuantity());
        return inventoryRepository.save(inventory);
    }


    public Inventory decreaseProductQuantity(String qrcode, Inventory inv) {
        Product p = getProductByQrcode(qrcode);
        if (p == null)
            return null;

        int productid = p.getId();
        Inventory inventory = getInventory(productid);
        int quantity = inv.getQuantity();
        if (inventory.getQuantity() >= quantity) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            return inventoryRepository.save(inventory);
        }
        return null;
    }

    public boolean deleteInventory(int id) {

        if (this.inventoryRepository.findById(id) == null)
            return false;
        else {
            inventoryRepository.deleteById(id);
            return true;
        }
    }
}
