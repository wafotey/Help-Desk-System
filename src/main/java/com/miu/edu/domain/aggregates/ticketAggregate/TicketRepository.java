package com.miu.edu.domain.aggregates.ticketAggregate;

public interface TicketRepository {
    void add(Ticket ticket);
    void update(Ticket ticket);
    Ticket findById(int id);
}

