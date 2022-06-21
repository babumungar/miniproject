package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exceptions.ResourceNotFoundException;

import com.stg.model.House;
import com.stg.repository.HouseRepository;
@Service
public class HouseInterfaceImpl implements HouseInterface {

	@Autowired
	private HouseRepository houseRepository;

	@Override
	public House create(House house) {

		return houseRepository.save(house);
	}

	@Override
	public List<House> findAllHouses() {

		List<House> house = houseRepository.findAllHouses();
		if (house.size() == 0) {
			throw new ResourceNotFoundException("No houses found!!!");
		} else {
			return house;
		}
	}

	@Override
	public House readById(int id) {

		House house = houseRepository.readById(id);
		if (house == null) {
			throw new ResourceNotFoundException("No house found!!!");
		} else {
			return house;
		}
	}

	@Override
	public House readByName(String name) {

		House house = houseRepository.readByName(name);
		if (house == null) {
			throw new ResourceNotFoundException("No house found!!!");
		} else {
			return house;
		}
	}

	@Override
	public String deleteById(int id) {

		houseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not exists"));
		houseRepository.deleteById(id);
		return "Success";
	}

	@Override
	public House updateById(int id, House house) {
		Optional<House> optional = houseRepository.findById(id);
		if (optional.isPresent()) {
			return houseRepository.save(house);
		} else {
			throw new ResourceNotFoundException("unsuccessful");
		}
	}

}
