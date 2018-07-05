package edu.birzeit.cocacola.application.controller;


import edu.birzeit.cocacola.application.model.Inventory;
import edu.birzeit.cocacola.application.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coca-cola/inventory")
public class InventoryController {


    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/")
    public ResponseEntity<List<Inventory>> getInventory() {

        List<Inventory> inventory = inventoryService.getInventory();

        if (inventory.size() == 0)
            return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.CONFLICT);
        else
            return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<Inventory> addProductToInventory(@RequestBody Inventory inventory) {
        Inventory i= inventoryService.addProductInventory(inventory);

        if (i == null)
            return new ResponseEntity<Inventory>(i, HttpStatus.CONFLICT);
        else
            return new ResponseEntity<Inventory>(i, HttpStatus.OK);

    }


}
