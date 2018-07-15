package edu.birzeit.cocacola.application.controller;


import edu.birzeit.cocacola.application.model.OrderDetail;
import edu.birzeit.cocacola.application.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coca-cola/orderdetails")
public class OrderDetailController {


    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/orderid/{orderid}")
    public ResponseEntity<List<OrderDetail>> getAllDetailsForOrder(@PathVariable int orderid) {

        List<OrderDetail> orderDetails = orderDetailService.getAllDetailsForOrder(orderid);
        if (orderDetails == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/orderid/{orderid}/productid/{productid}")
    public ResponseEntity<OrderDetail> addDetailForOrder(@RequestBody OrderDetail orderDetail, @PathVariable int orderid, @PathVariable int productid) {

        OrderDetail orderDetail1 = this.orderDetailService.addDetailForOrder(orderDetail, orderid, productid);
        if (orderDetail1 == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        else
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable("id") int id, @RequestBody OrderDetail orderDetail) {
        OrderDetail orderDetail1 = this.orderDetailService.updateOrderDetail(id, orderDetail);
        if (orderDetail == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") int id) {

        if (this.orderDetailService.deleteOrderDetail(id))
            return new ResponseEntity<>(HttpStatus.OK);

        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
