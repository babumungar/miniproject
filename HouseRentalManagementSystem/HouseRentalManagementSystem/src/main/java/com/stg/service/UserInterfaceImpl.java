package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.exceptions.ResourceNotFoundException;

import com.stg.model.User;

import com.stg.repository.UserRepository;

@Service

public class UserInterfaceImpl implements UserInterface {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		List<User> user = userRepository.findAllUsers();
		if (user.size() == 0) {
			throw new ResourceNotFoundException("No users found!!!");
		} else {
			return user;
		}
	}

	@Override
	public User readById(int id) {
		User user = userRepository.readById(id);
		if (user == null) {
			throw new ResourceNotFoundException("No users found!!!");
		} else {
			return user;
		}
	}

	@Override
	public User readByName(String name) {
		User user = userRepository.readByName(name);
		if (user == null) {
			throw new ResourceNotFoundException("No users found!!!");
		} else {
			return user;
		}
	}

	@Override
	public String deleteById(int id) {
		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not exists"));
		userRepository.deleteById(id);
		return "Success";
	}

	@Override
	public User updateById(int id, User user) throws ResourceNotFoundException {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return userRepository.save(user);
		} else {
			throw new ResourceNotFoundException("unsuccessful");
		}
	}
}
