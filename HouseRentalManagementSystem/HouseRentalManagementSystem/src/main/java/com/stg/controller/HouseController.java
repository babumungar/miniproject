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

import com.stg.model.House;

import com.stg.service.HouseInterface;

@RestController
@RequestMapping(value = "house")
public class HouseController {

	@Autowired
	private HouseInterface houseInterface;

	@PostMapping(value = "create")
	public ResponseEntity<House> createHouse(@RequestBody House house) {
		return new ResponseEntity<House>(houseInterface.create(house), HttpStatus.CREATED);
	}

	@GetMapping(value = "readallhouses")
	public ResponseEntity<List<House>> readAllHouses() {
		return new ResponseEntity<List<House>>(houseInterface.findAllHouses(), HttpStatus.FOUND);
	}

	@GetMapping(value = "readbyid/{a}")
	public ResponseEntity<House> readById(@PathVariable("a") int id) {
		return new ResponseEntity<House>(houseInterface.readById(id), HttpStatus.FOUND);
	}

	@GetMapping(value = "readbyname/{a}")
	public ResponseEntity<House> readByName(@PathVariable("a") String name) {
		return new ResponseEntity<House>(houseInterface.readByName(name), HttpStatus.FOUND);
	}

	@DeleteMapping(value = "deletebyid/{a}")
	public ResponseEntity<String> deleteById(@PathVariable("a") int id) {
		return new ResponseEntity<String>(houseInterface.deleteById(id), HttpStatus.GONE);
		// return "success";
	}

	@PutMapping(value = "update/{id}")
	public ResponseEntity<House> updateById(@PathVariable int id, @RequestBody House house) {
		return new ResponseEntity<House>(houseInterface.updateById(id, house), HttpStatus.ACCEPTED);

	}

}
