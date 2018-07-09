package edu.birzeit.cocacola.application.service;

import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);
        return users;
    }


    public User addUser(User user) {


        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if (userRepository.findById(user.getId()) == null)
            return null;
        return userRepository.save(user);
    }

    public boolean deleteUser(int id) {
        if (userRepository.findById(id) != null) { // exist{
            userRepository.deleteById(id);
            return true;
        } else
            return false;
    }


    public User getUser(int id) {
        return userRepository.findById(id);
    }


}
