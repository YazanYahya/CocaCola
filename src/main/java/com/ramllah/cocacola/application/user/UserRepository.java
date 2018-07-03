package com.ramllah.cocacola.application.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


    public User findById(int id);


    @Transactional
    @Modifying
    public void deleteById(int id);
	

}
