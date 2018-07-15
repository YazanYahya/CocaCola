package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.TruckOrder;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckOrderRepository extends JpaRepository<TruckOrder, Integer> {

    TruckOrder findById(int id);

   // List<TruckOrder> findAllByUserId(int id);
}
