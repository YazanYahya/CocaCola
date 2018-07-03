package com.ramllah.cocacola.application.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/coca-cola")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

}
