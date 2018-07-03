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

}