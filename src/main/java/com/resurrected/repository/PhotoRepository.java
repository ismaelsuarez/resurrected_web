package com.resurrected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.resurrected.entity.Photo;



@Repository
public interface PhotoRepository extends JpaRepository<Photo,String> {

	
	
	@Query("SELECT a FROM Photo a WHERE a.status=true")
	public List<Photo> listTrue();
	
	
	
}
