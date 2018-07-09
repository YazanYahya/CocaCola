package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String> {


    //@Query("UPDATE i FROM inventory i set i.quantity= i.quantity + quantity WHERE i.product_id = :product_id")
    //void increaseQuantity(@Param("product_id") int product_id, @Param("quantity") int quantity);

    Inventory findByProduct_id(int id);


}
