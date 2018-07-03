package com.ramllah.cocacola.application.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coca-cola")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers() {
	
		List<User> users = userService.getAllUsers();
		
		System.out.println(users.size()+"\n\n\n");
	     return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
