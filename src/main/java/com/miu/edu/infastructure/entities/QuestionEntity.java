package com.miu.edu.infastructure.entities;

import jakarta.persistence.*;

@Entity(name = "Question")
public class QuestionEntity extends MessageEntity {

    @Column(name = "ticket_id", nullable = false)  // Ensuring that the field is not null
    private int ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TicketEntity ticket;

    // Default constructor for JPA
    protected QuestionEntity() {
    }

    // Constructor with parameters
    public QuestionEntity(String question, int ticketId) {
        this.description = question;
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
