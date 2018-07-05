package edu.birzeit.cocacola.application.repository;

import edu.birzeit.cocacola.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findById(int id);

    @Transactional
    @Modifying
    void deleteById(int id);


}
