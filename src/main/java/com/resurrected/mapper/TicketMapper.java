package com.resurrected.mapper;

import com.resurrected.entity.Ticket;
import com.resurrected.model.TicketModel;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public Ticket toEntity(TicketModel model){
        return Ticket.builder()
                .id(model.getId())
                .status(model.getStatus())
                .delivery(model.getDelivery())
                .payment(model.getPayment())
                .load(model.getLoad())
                .edit(model.getEdit())
                .client(model.getClient())
                .cashRegister(model.getCashRegister())
                .products(model.getProducts())
                .build();
    }

    public TicketModel toModel(Ticket ticket){
        return TicketModel.builder()
                .id(ticket.getId())
                .status(ticket.getStatus())
                .delivery(ticket.getDelivery())
                .payment(ticket.getPayment())
                .load(ticket.getLoad())
                .edit(ticket.getEdit())
                .client(ticket.getClient())
                .cashRegister(ticket.getCashRegister())
                .products(ticket.getProducts())
                .build();
    }
}
