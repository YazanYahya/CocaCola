package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    Inventory findByProduct_id(int id);
    Inventory findById(int id);
    void deleteById(int id);


}
