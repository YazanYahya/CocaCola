package edu.birzeit.cocacola.application.service;

import edu.birzeit.cocacola.application.model.Product;
import edu.birzeit.cocacola.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        if (productRepository.findById(product.getId()) == null)
            return null;
        return productRepository.save(product);
    }

    public boolean deleteProduct(int id) {
        if (productRepository.findById(id) != null) { // exist{
            productRepository.deleteById(id);
            return true;
        } else
            return false;
    }


    public Product getProduct(int id) {
        return productRepository.findById(id);
    }

    public Product getProductByQRCode(String qrcode) {
        return this.productRepository.findByQrcode(qrcode);
    }

    public List<Product> getProductsByCategory(String category) {
        return this.productRepository.findByCategory(category);
    }

    public List<Product> getProductsByDescription(String description) {
        return this.productRepository.findByDescription(description);
    }

}