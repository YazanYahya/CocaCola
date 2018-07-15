package edu.birzeit.cocacola.application.controller;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int id) {

        Inventory i = inventoryService.getInventoryById(id);
        if (i == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(i, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/qrcode/{qrcode}")
    public ResponseEntity<Inventory> getInventoryByQrcode(@PathVariable String qrcode) {

        Inventory i = inventoryService.getInventoryByQrcode(qrcode);
        if (i == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/productid/{product_id}")
    public ResponseEntity<Inventory> addProductToInventory(@RequestBody Inventory inventory, @PathVariable int product_id) {

        Inventory i = inventoryService.addProductInventory(inventory, product_id);
        if (i == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(i, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/qrcode/{qrcode}/increase")
    public ResponseEntity<Inventory> increaseProductQuantity(@PathVariable String qrcode, @RequestBody Inventory inventory) {
        Inventory inv = inventoryService.increaseProductQuantity(qrcode, inventory);
        if (inv == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        else
            return new ResponseEntity<>(inv, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/qrcode/{qrcode}/decrease")
    public ResponseEntity<Inventory> decreaseProductQuantity(@PathVariable String qrcode, @RequestBody Inventory inventory) {
        Inventory inv = inventoryService.decreaseProductQuantity(qrcode, inventory);
        if (inv == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        else
            return new ResponseEntity<>(inv, HttpStatus.OK);


    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Inventory> deleteInventoryOfProduct(@PathVariable("id") int id) {
        if (this.inventoryService.deleteInventory(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }


}
