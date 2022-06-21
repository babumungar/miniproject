package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.model.House;

@Repository
public interface HouseRepository extends CrudRepository<House, Integer> {

	@Query(value = "SELECT * FROM house", nativeQuery = true)
	public abstract List<House> findAllHouses();

	@Query(value = "SELECT* FROM house a where a.house_id = :var1", nativeQuery = true)
	public abstract House readById(@Param("var1") int id);

	@Query(value = "SELECT* FROM house a where a.house_name = :var1", nativeQuery = true)
	public abstract House readByName(@Param("var1") String name);

	

}
