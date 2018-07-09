package edu.birzeit.cocacola.application.service;


import edu.birzeit.cocacola.application.model.Inventory;
import edu.birzeit.cocacola.application.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getInventory() {
        List<Inventory> inventory = new ArrayList<>();
        inventoryRepository.findAll().forEach(inventory::add);
        return inventory;
    }


    public Inventory addProductInventory(Inventory inventory) {

        return inventoryRepository.save(inventory);
    }


    public Inventory getInventory(int product_id) {
        return inventoryRepository.findByProduct_id(product_id);
    }


    public void increaseProductQuantity(int id, int quantity) {

        Inventory inventory = getInventory(id);
        inventory.setQuantity(inventory.getQuantity() + quantity);
        inventoryRepository.save(inventory);
    }


    public void decreaseProductQuantity(int id, int quantity) {

        Inventory inventory = getInventory(id);
        if (inventory.getQuantity() > 0) {
            inventory.setQuantity(inventory.getQuantity() - quantity);
            inventoryRepository.save(inventory);
        }
    }
}
