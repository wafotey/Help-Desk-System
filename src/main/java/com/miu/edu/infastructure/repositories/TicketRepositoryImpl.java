package com.miu.edu.infastructure.repositories;

import com.miu.edu.domain.aggregates.ticketAggregate.Ticket;
import com.miu.edu.domain.aggregates.ticketAggregate.TicketRepository;
import com.miu.edu.infastructure.entities.TicketEntity;
import com.miu.edu.infastructure.utilities.EntityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepositoryImpl implements TicketRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public TicketRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Ticket ticket) {
        TicketEntity ticketEntity = EntityMapper.toEntity(ticket,TicketEntity.class);
        entityManager.persist(ticketEntity);
    }

    @Override
    public void update(Ticket ticket) {
        entityManager.merge(ticket);
    }

    @Override
    public Ticket findById(int id) {
        var ticketEntity = entityManager.find(TicketEntity.class, id);
        return EntityMapper.toDomain(ticketEntity,Ticket.class);
    }
}