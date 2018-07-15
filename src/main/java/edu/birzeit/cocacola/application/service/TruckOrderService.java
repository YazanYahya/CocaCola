package edu.birzeit.cocacola.application.service;

import edu.birzeit.cocacola.application.model.TruckOrder;
import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.repository.TruckOrderRepository;
import edu.birzeit.cocacola.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TruckOrderService {


    @Autowired
    private TruckOrderRepository truckOrderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TruckOrder> getAllOrders() {

        List<TruckOrder> truckOrders = new ArrayList<>();

        truckOrderRepository.findAll().forEach(truckOrders::add);
        return truckOrders;
    }


    public TruckOrder getOrderById(int id) {

        return this.truckOrderRepository.findById(id);
    }

   /* public List<TruckOrder> getOrdersByLoriId(int lori_id) {

        return this.truckOrderRepository.findByX(lori_id);
    }


    public List<TruckOrder> getOrdersByTruckDriverId(int truck_driver_id) {

        return this.truckOrderRepository.findByUsertruckdriverid(truck_driver_id);
    }*/

    public TruckOrder addOrder(TruckOrder truckOrder, int truck_driver_id, int lori_id) {

        User lori = this.userRepository.findById(lori_id);
        User truck_driver = this.userRepository.findById(truck_driver_id);

        if (lori != null && truck_driver != null && lori.getRole() == User.LORI_ROLE && truck_driver.getRole() == User.TRUCK_DRIVER_ROLE) {
            truckOrder.setUserLori(lori);
            truckOrder.setUserTruckDriver(truck_driver);
            return this.truckOrderRepository.save(truckOrder);
        } else
            return null;
    }

    public TruckOrder updateOrder(TruckOrder truckOrder) {
        if (this.truckOrderRepository.findById(truckOrder.getId()) == null)
            return null;
        else
            return this.truckOrderRepository.save(truckOrder);

    }


    public boolean deleteOrder(int id) {
        if (this.truckOrderRepository.findById(id) == null)
            return false;
        else {
            this.truckOrderRepository.deleteById(id);
            return true;
        }

    }


}
