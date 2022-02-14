package com.resurrected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.resurrected.entity.Product;
import com.resurrected.enums.Status;



@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


	
	@Query("SELECT a FROM Product a WHERE a.id=:id")
	public Product findId(@Param("id")String id);
	
	@Query("SELECT a FROM Product a")
	public List<Product>findAllS();
	
	@Query("SELECT a FROM Product a WHERE a.status= :status")
	public List<Product> findByStatus(@Param("status") Status status);

	
}
