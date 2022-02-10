package com.resurrected.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.resurrected.entity.Ticket;


@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {

	@Query("SELECT a FROM Ticket a WHERE a.status=true")
	public List<Ticket> findTrue();

	@Query("SELECT a FROM Ticket a WHERE a.status=false")
	public List<Ticket> findFalse();

	@Query("SELECT a FROM Ticket a WHERE a.delivery=true")
	public List<Ticket> findDeliveryTrue();

	@Query("SELECT a FROM Ticket a WHERE a.delivery=false")
	public List<Ticket> findDeliveryFalse();

	@Query("SELECT a FROM Ticket a WHERE a.id LIKE :id")
	public Ticket findId(@Param("id") String id);

	@Query("SELECT a FROM Ticket a WHERE a.payment=true")
	public List<Ticket> findPayTrue();

	@Query("SELECT a FROM Ticket a WHERE a.payment=false")
	public List<Ticket> findPayFalse();

}
