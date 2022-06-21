package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query(value = "SELECT * FROM user", nativeQuery = true)
	public abstract List<User> findAllUsers();

	@Query(value = "SELECT* FROM user a where a.user_id = :var1", nativeQuery = true)
	public abstract User readById(@Param("var1") int id);

	@Query(value = "SELECT* FROM user a where a.user_name = :var1", nativeQuery = true)
	public abstract User readByName(@Param("var1") String name);

	
}
