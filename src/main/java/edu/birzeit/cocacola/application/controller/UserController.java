package edu.birzeit.cocacola.application.controller;

import java.util.List;
import edu.birzeit.cocacola.application.model.User;
import edu.birzeit.cocacola.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coca-cola/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/")
    public ResponseEntity<List<User>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable int id) {
        User user = userService.getUser(id);

        if (user != null)
            return new ResponseEntity<User>(user, HttpStatus.OK);
        else
            return new ResponseEntity<User>(user, HttpStatus.CONFLICT);

    }


    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User u = userService.addUser(user);
        if (u == null)
            return new ResponseEntity<User>(u, HttpStatus.CONFLICT);
        else
            return new ResponseEntity<User>(u, HttpStatus.OK);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
        user.setId(id);

        User u = userService.updateUser(user);
        if (u == null)
            return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<User>(u, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {

        if (userService.deleteUser(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

}
