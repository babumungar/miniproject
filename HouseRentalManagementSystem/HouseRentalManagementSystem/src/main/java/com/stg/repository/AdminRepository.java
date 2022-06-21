package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stg.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {

	@Query(value = "SELECT * FROM admin", nativeQuery = true)
	public abstract List<Admin> findAllAdmins();

	@Query(value = "SELECT* FROM admin a where a.admin_id = :var1", nativeQuery = true)
	public abstract Admin readById(@Param("var1") int id);

	@Query(value = "SELECT* FROM admin a where a.admin_name = :var1", nativeQuery = true)
	public abstract Admin readByName(@Param("var1") String name);

}
