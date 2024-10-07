package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer>{

	@Query("SELECT c.fare FROM Cab c WHERE c.cid = ?1")
    Double findFareByCabId(int cid);
	
}
