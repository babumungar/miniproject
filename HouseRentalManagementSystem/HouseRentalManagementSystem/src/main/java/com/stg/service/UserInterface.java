package com.stg.service;

import java.util.List;

import com.stg.exceptions.ResourceNotFoundException;
import com.stg.model.User;

public interface UserInterface {
	public abstract User create(User admin);

	public abstract List<User> findAllUsers() throws ResourceNotFoundException;

	public abstract User readById(int id) throws ResourceNotFoundException;

	public abstract User readByName(String name) throws ResourceNotFoundException;

	public abstract String deleteById(int id) throws ResourceNotFoundException;

	public abstract User updateById(int id, User user) throws ResourceNotFoundException;

}
