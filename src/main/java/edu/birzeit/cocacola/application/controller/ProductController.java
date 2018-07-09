package edu.birzeit.cocacola.application.controller;

import edu.birzeit.cocacola.application.model.Product;
import edu.birzeit.cocacola.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping(value = "/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable int id) {
        Product product = productService.getProduct(id);

        if (product != null)
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        else
            return new ResponseEntity<Product>(product, HttpStatus.CONFLICT);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product p = productService.addProduct(product);
        if (p == null)
            return new ResponseEntity<Product>(p, HttpStatus.CONFLICT);
        else
            return new ResponseEntity<Product>(p, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id) {
        product.setId(id);
        Product p = productService.updateProduct(product);
        if (p == null)
            return new ResponseEntity<Product>(p, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Product>(p, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {

        if (productService.deleteProduct(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

}
