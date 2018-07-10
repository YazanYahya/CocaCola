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

    @RequestMapping(method = RequestMethod.POST, value = "/{product_id}")
    public ResponseEntity<Inventory> addProductToInventory(@RequestBody Inventory inventory, @PathVariable int product_id) {

        Inventory i = inventoryService.addProductInventory(inventory, product_id);

        return new ResponseEntity<>(i, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{qrcode}/increase")
    public ResponseEntity<Inventory> increaseProductQuantity(@PathVariable String qrcode,@RequestBody Inventory inventory) {
        inventoryService.increaseProductQuantity(qrcode,inventory);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{qrcode}/decrease")
    public ResponseEntity<Inventory> decreaseProductQuantity(@PathVariable String qrcode,@RequestBody Inventory inventory) {
        inventoryService.decreaseProductQuantity(qrcode, inventory);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
