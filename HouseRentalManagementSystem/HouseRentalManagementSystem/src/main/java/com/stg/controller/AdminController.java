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

import com.stg.model.Admin;

import com.stg.service.AdminInterface;

@RestController
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminInterface adminInterface;

	@PostMapping(value = "create")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminInterface.create(admin), HttpStatus.CREATED);
	}

	@GetMapping(value = "readalladmins")
	public ResponseEntity<List<Admin>> readAllAdmins() {
		return new ResponseEntity<List<Admin>>(adminInterface.findAllAdmins(), HttpStatus.FOUND);
	}

	@GetMapping(value = "readbyid/{a}")
	public ResponseEntity<Admin> readById(@PathVariable("a") int id) {
		return new ResponseEntity<Admin>(adminInterface.readById(id), HttpStatus.FOUND);
	}

	@GetMapping(value = "readbyname/{a}")
	public ResponseEntity<Admin> readByName(@PathVariable("a") String name) {
		return new ResponseEntity<Admin>(adminInterface.readByName(name), HttpStatus.FOUND);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public ResponseEntity<String> deleteById(@PathVariable("a") int id) {
		return new ResponseEntity<String>(adminInterface.deleteById(id), HttpStatus.GONE);
		// return "success";
	}

	@PutMapping(value = "update/{id}")
	public ResponseEntity<Admin> updateById(@PathVariable int id, @RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminInterface.updateById(id, admin), HttpStatus.ACCEPTED);

	}

}
