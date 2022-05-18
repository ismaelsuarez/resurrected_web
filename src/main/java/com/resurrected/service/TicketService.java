package com.resurrected.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resurrected.entity.Product;
import com.resurrected.entity.Ticket;
import com.resurrected.entity.Client;
import com.resurrected.error.ErrorService;
import com.resurrected.repository.TicketRepository;
import com.resurrected.repository.ClientRepository;

@Service
public class TicketService {

	private final ClientRepository personRepository;
	private final TicketRepository ticketRepository;

	public TicketService(ClientRepository personRepository, TicketRepository ticketRepository) {
		this.personRepository = personRepository;
		this.ticketRepository = ticketRepository;
	}

	@Transactional
	public Ticket loadTicket(String idClient, List<Product> product) throws ErrorService {

		Optional<Client> check = personRepository.findById(idClient);

		if (check != null) {
			Client client = check.get();
			Ticket ticket = Ticket.builder()
					.client(client)
					.products(product)
					.load(new Date())
					.status(Boolean.TRUE)
					.build();
			return ticketRepository.save(ticket);
		} else {

			throw new ErrorService("No se encuentra el id del cliente para asignar el pedido");
		}

	}

	@Transactional
	public Ticket editticket(String idticket, List<Product> product) throws ErrorService {

		Optional<Ticket> check = ticketRepository.findById(idticket);

		if (check != null) {
			Ticket ticket = check.get();
			ticket.setProducts(product);
			ticket.setEdit(new Date());
			return ticketRepository.save(ticket);
		} else {

			throw new ErrorService("No se encuentra la ticket para modificar");
		}
	}

	@Transactional
	public Ticket deliveryTrue(String idticket) throws ErrorService {
		Optional<Ticket> check = ticketRepository.findById(idticket);

		if (check != null) {

			Ticket ticket = check.get();
			ticket.setDelivery(true);
			ticket.setStatus(false);

			return ticketRepository.save(ticket);
		} else {

			throw new ErrorService("No se encuentra la orden para dar como entregada");
		}

	}

	@Transactional
	public Ticket deliveryFalse(String idticket) throws ErrorService {
		Optional<Ticket> check = ticketRepository.findById(idticket);

		if (check != null) {

			Ticket ticket = check.get();
			ticket.setDelivery(false);
			ticket.setStatus(true);

			return ticketRepository.save(ticket);
		} else {

			throw new ErrorService("No se encuentra la orden para informar que no se puede entregar");
		}

	}

	@Transactional
	public void removeticket(String idticket) throws ErrorService {

		Optional<Ticket> check = ticketRepository.findById(idticket);
		if (check != null) {
			Ticket ticket = check.get();
			ticket.setProducts(null);
			ticket.setClient(null);
			ticketRepository.delete(ticket);

		} else {

			throw new ErrorService("No se encuentra la ticket para eliminar");
		}

	}

	@Transactional(readOnly = true)
	public List<Ticket> findTrue() {
		return ticketRepository.findTrue();
	}

	@Transactional(readOnly = true)
	public List<Ticket> findFalse() {
		return ticketRepository.findFalse();
	}

	@Transactional(readOnly = true)
	public List<Ticket> findDeliveryTrue() {
		return ticketRepository.findDeliveryTrue();
	}

	@Transactional(readOnly = true)
	public List<Ticket> findDeliveryFalse() {
		return ticketRepository.findDeliveryFalse();
	}

	@Transactional(readOnly = true)
	public Ticket finId(String id) {
		return ticketRepository.findId(id);
	}

	@Transactional(readOnly = true)
	public Optional<Ticket> findIdticket(String id) {
		return ticketRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Ticket>findPayTrue(){
		return ticketRepository.findPayTrue();
	}
	
	@Transactional(readOnly = true)
	public List<Ticket>findPayFalse(){
		return ticketRepository.findPayFalse();
	}
	
	
}
