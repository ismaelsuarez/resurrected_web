package com.resurrected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.resurrected.entity.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

	@Query("SELECT a FROM Client a WHERE a.email= :email")
	public Client findEmail(@Param("email") String email);
	
	@Query("SELECT a FROM Client a WHERE a.email= :email AND a.id != :id")
	public Client findEmailAndID(@Param("email") String email, @Param("id") String id);

	@Query("SELECT a FROM Client a WHERE a.active=true")
	public List<Client> findTrue();

	@Query("SELECT a FROM Client a WHERE a.active=false")
	public List<Client> findFalse();

	@Query("SELECT a FROM Client a WHERE a.id=:id")
	public Client findId(@Param("id") String id);

	@Query("SELECT a FROM Client a WHERE a.document=:document")
	public Client findDni(@Param("document") Long document);

	@Query("SELECT a FROM Client a WHERE a.phoneNumber= :phoneNumber")
	public Client findPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
