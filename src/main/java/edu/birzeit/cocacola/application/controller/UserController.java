package edu.birzeit.cocacola.application.controller;

import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/coca-cola/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable int id) {
        User user = userService.getUser(id);

        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
c
    }


    @RequestMapping(method = RequestMethod.GET, value = "/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable int role) {
        List<User> users = userService.getUsersByRole(role);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User u = userService.addUser(user);
        return new ResponseEntity<>(u, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
        user.setId(id);

        User u = userService.updateUser(user);
        if (u == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(u, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {

        if (userService.deleteUser(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
