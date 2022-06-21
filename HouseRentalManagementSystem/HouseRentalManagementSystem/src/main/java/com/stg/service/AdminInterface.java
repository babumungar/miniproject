
package com.stg.service;

import java.util.List;

import com.stg.exceptions.ResourceNotFoundException;
import com.stg.model.Admin;

public interface AdminInterface {
	public abstract Admin create(Admin admin);

	public abstract List<Admin> findAllAdmins() throws ResourceNotFoundException;

	public abstract Admin readById(int id) throws ResourceNotFoundException;

	public abstract Admin readByName(String name) throws ResourceNotFoundException;

	public abstract String deleteById(int id) throws ResourceNotFoundException;

	public abstract Admin updateById(int id, Admin admin) throws ResourceNotFoundException;

}
