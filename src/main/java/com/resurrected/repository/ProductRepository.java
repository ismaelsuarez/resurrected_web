package com.resurrected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.resurrected.entity.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


	
//	@Query("SELECT a FROM Product a WHERE a.id=:idS")
//	public Product findId(@Param("id")String idS);
	
	@Query("SELECT a FROM Product a")
	public List<Product>findAllS();
	
//	@Query("SELECT a FROM Product u WHERE u.name LIKE %:q%"
	//		)
//	public List<Product> findAll(String q);
	

}
