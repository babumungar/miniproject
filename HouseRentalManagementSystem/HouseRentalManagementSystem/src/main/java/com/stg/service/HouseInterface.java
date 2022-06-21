package com.stg.service;

import java.util.List;

import com.stg.exceptions.ResourceNotFoundException;

import com.stg.model.House;

public interface HouseInterface {
	public abstract House create(House house);

	public abstract List<House> findAllHouses() throws ResourceNotFoundException;

	public abstract House readById(int id) throws ResourceNotFoundException;

	public abstract House readByName(String name) throws ResourceNotFoundException;

	public abstract String deleteById(int id) throws ResourceNotFoundException;

	public abstract House updateById(int id, House house) throws ResourceNotFoundException;

}
