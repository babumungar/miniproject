package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.model.User;

import com.stg.service.UserInterface;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserInterface userInterface;

	@PostMapping(value = "create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userInterface.create(user), HttpStatus.CREATED);
	}

	@GetMapping(value = "readallusers")
	public ResponseEntity<List<User>> readAllUsers() {
		return new ResponseEntity<List<User>>(userInterface.findAllUsers(), HttpStatus.FOUND);
	}

	@GetMapping(value = "readbyid/{a}")
	public ResponseEntity<User> readById(@PathVariable("a") int id) {
		return new ResponseEntity<User>(userInterface.readById(id), HttpStatus.FOUND);
	}

	@GetMapping(value = "readbyname/{a}")
	public ResponseEntity<User> readByName(@PathVariable("a") String name) {
		return new ResponseEntity<User>(userInterface.readByName(name), HttpStatus.FOUND);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public ResponseEntity<String> deleteById(@PathVariable("a") int id) {
		return new ResponseEntity<String>(userInterface.deleteById(id), HttpStatus.GONE);
		// return "success";
	}

	@PutMapping(value = "update/{id}")
	public ResponseEntity<User> updateById(@PathVariable int id, @RequestBody User user) {
		return new ResponseEntity<User>(userInterface.updateById(id, user), HttpStatus.ACCEPTED);

	}

}
