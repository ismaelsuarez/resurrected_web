package com.resurrected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.resurrected.entity.CashRegister;


@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, String> {

	@Query("SELECT a FROM CashRegister a WHERE a.status=true")
	public List<CashRegister> findTrue();

	@Query("SELECT a FROM CashRegister a WHERE a.status=false")
	public List<CashRegister> findFalse();


}
