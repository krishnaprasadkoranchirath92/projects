package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.User;
import com.api.repos.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	private UserRepo repo;

	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		System.out.println(user);
		repo.save(user);
		return new ResponseEntity<String>("User Saved", HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<String> getUser() {
		return new ResponseEntity<String>("User1", HttpStatus.OK);
	}

	@GetMapping("/api/foos")
	public String getFoos(@RequestParam(required = false) String id, @RequestParam String name) {
		return "ID: " + id + ", Name: " + name;
	}
}
