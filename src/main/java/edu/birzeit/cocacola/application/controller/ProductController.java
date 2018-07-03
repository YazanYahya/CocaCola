package edu.birzeit.cocacola.application.controller;

import edu.birzeit.cocacola.application.model.Product;
import edu.birzeit.cocacola.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/coca-cola/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

}
