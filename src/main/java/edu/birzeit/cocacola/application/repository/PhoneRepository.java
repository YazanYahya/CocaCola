package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {


    List<Phone> findByUser_id(int user_id);
}
