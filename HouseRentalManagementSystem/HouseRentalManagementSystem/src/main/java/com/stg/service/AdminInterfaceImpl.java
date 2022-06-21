
package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stg.exceptions.ResourceNotFoundException;
import com.stg.model.Admin;
import com.stg.repository.AdminRepository;

@Service
public class AdminInterfaceImpl implements AdminInterface {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin create(Admin admin) {

		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> findAllAdmins() {
		List<Admin> admins = adminRepository.findAllAdmins();
		if (admins.size() == 0) {
			throw new ResourceNotFoundException("No admins found!!!");
		} else {
			return admins;
		}

	}

	@Override
	public Admin readById(int id) {
		Admin admin = adminRepository.readById(id);

		if (admin == null) {
			throw new ResourceNotFoundException("No admin found!!!");
		} else {
			return admin;
		}

	}

	@Override
	public Admin readByName(String name) {

		Admin admin = adminRepository.readByName(name);
		if (admin == null) {
			throw new ResourceNotFoundException("No admin found!!!");
		} else {
			return admin;
		}
	}

	@Override
	public String deleteById(int id) {
		adminRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not exists"));
		adminRepository.deleteById(id);
		return "Success";
	}

	@Override
	public Admin updateById(int id, Admin admin) {
		Optional<Admin> optional =  adminRepository.findById(id);
		if (optional.isPresent()) {
		return adminRepository.save(admin);
		}else {
			throw new ResourceNotFoundException("unsuccessful");
		}
	}

}
