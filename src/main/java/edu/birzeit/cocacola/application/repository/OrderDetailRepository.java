package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.OrderDetail;
import edu.birzeit.cocacola.application.model.TruckOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {


    List<OrderDetail> findByTruckOrderId(int truck_order_id);

    OrderDetail findById(int id);
}
