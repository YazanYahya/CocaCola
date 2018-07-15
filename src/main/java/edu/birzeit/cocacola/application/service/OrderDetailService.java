package edu.birzeit.cocacola.application.service;

import edu.birzeit.cocacola.application.model.OrderDetail;
import edu.birzeit.cocacola.application.model.Product;
import edu.birzeit.cocacola.application.model.TruckOrder;
import edu.birzeit.cocacola.application.repository.OrderDetailRepository;
import edu.birzeit.cocacola.application.repository.ProductRepository;
import edu.birzeit.cocacola.application.repository.TruckOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private TruckOrderRepository truckOrderRepository;

    @Autowired
    private ProductRepository productRepository;


    public List<OrderDetail> getAllDetailsForOrder(int orderid) {

        if (truckOrderRepository.findById(orderid) == null)
            return null;
        else
            return this.orderDetailRepository.findByTruckOrderId(orderid);
    }

    public OrderDetail addDetailForOrder(OrderDetail orderDetail, int orderid, int productid) {
        TruckOrder truckOrder = this.truckOrderRepository.findById(orderid);
        Product product = this.productRepository.findById(productid);

        if (truckOrder != null && product != null) {
            orderDetail.setTruckOrder(truckOrder);
            orderDetail.setProduct(product);
            return this.orderDetailRepository.save(orderDetail);
        } else
            return null;
    }


    public OrderDetail updateOrderDetail(int id, OrderDetail orderDetail) {
        OrderDetail detail = this.orderDetailRepository.findById(id);
        if (detail == null)
            return null;
        orderDetail.setId(id);
        return this.orderDetailRepository.save(orderDetail);

    }

    public boolean deleteOrderDetail(int id) {
        if (this.orderDetailRepository.findById(id) != null) {
            this.orderDetailRepository.findById(id);
            return true;
        } else
            return false;

    }


}
