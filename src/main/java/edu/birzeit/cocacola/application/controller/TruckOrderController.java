package edu.birzeit.cocacola.application.controller;

import edu.birzeit.cocacola.application.model.TruckOrder;
import edu.birzeit.cocacola.application.service.TruckOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coca-cola/orders")
public class TruckOrderController {

    @Autowired
    private TruckOrderService truckOrderService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<TruckOrder>> getAllOrders() {

        List<TruckOrder> users = truckOrderService.getAllOrders();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<TruckOrder> getOrderById(@PathVariable int id) {


        TruckOrder truckOrder = this.truckOrderService.getOrderById(id);

        if (truckOrder != null)
            return new ResponseEntity<>(truckOrder, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    /*
        @RequestMapping(method = RequestMethod.GET, value = "/lori_id/{lori_id}")
        public ResponseEntity<List<TruckOrder>> getOrdersByLoriId(@PathVariable int lori_id) {

            List<TruckOrder> truckOrders = truckOrderService.getOrdersByLoriId(lori_id);

            return new ResponseEntity<>(truckOrders, HttpStatus.OK);
        }


        @RequestMapping(method = RequestMethod.GET, value = "/truck_driver_id/{truck_driver_id}")
        public ResponseEntity<List<TruckOrder>> getOrderByTruckDriverId(@PathVariable int truck_driver_id) {

            List<TruckOrder> truckOrders = truckOrderService.getOrdersByTruckDriverId(truck_driver_id);

            return new ResponseEntity<>(truckOrders, HttpStatus.OK);

        }
    */
    @RequestMapping(method = RequestMethod.POST, value = "/truck_driver_id/{truck_driver_id}/lori_id/{lori_id}")
    public ResponseEntity<TruckOrder> addOrder(@RequestBody TruckOrder truckOrder, @PathVariable int truck_driver_id, @PathVariable int lori_id) {

        TruckOrder order = this.truckOrderService.addOrder(truckOrder, truck_driver_id, lori_id);
        if (order == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        else
            return new ResponseEntity<>(order, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<TruckOrder> updateOrder(@RequestBody TruckOrder truckOrder, @PathVariable int id) {

        truckOrder.setId(id);
        TruckOrder o = this.truckOrderService.updateOrder(truckOrder);
        if (o == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(o, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable int id) {

        if (this.truckOrderService.deleteOrder(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
