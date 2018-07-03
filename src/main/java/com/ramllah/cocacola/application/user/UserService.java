package com.ramllah.cocacola.application.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		userRepository.findAll().forEach(users::add);
		return users;
	}

}
