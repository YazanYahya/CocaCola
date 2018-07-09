package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Product findById(int id);
    Product findByQrcode (String qrcode);
    List<Product> findByCategory(String category);

    @Transactional
    @Modifying
    void deleteById(int id);


}