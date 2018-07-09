package edu.birzeit.cocacola.application.controller;


import edu.birzeit.cocacola.application.model.Inventory;
import edu.birzeit.cocacola.application.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coca-cola/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/")
    public ResponseEntity<List<Inventory>> getInventory() {

        List<Inventory> inventory = inventoryService.getInventory();

        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Inventory> addProductToInventory(@RequestBody Inventory inventory) {
        Inventory i = inventoryService.addProductInventory(inventory);

        return new ResponseEntity<>(i, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/increase/{quantity}")
    public ResponseEntity<Inventory> increaseProductQuantity(@PathVariable int id, @PathVariable int quantity) {

        inventoryService.increaseProductQuantity(id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/decrease/{quantity}")
    public ResponseEntity<Inventory> decreaseProductQuantity(@PathVariable int id, @PathVariable int quantity) {
        inventoryService.decreaseProductQuantity(id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
