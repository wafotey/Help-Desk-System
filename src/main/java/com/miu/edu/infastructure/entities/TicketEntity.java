package com.miu.edu.infastructure.entities;

import com.miu.edu.domain.aggregates.ticketAggregate.Priority;
import com.miu.edu.domain.aggregates.ticketAggregate.TicketStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate ID for Ticket
    private int id;  // Unique identifier for Ticket

    @Column(name = "customer_id", nullable = false)  // Ensuring that the field is not null
    private int customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToOne(cascade = CascadeType.PERSIST) // Assuming Issue is another entity
    @JoinColumn(name = "issue_id", referencedColumnName = "id", nullable = false)
    private IssueEntity issue;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  // Assuming Message is an entity and has a 'ticket' reference
    private List<MessageEntity> messages = new ArrayList<>();  // Initialize to avoid null pointer issues

    @Enumerated(EnumType.STRING)  // Persist TicketStatus as a string
    private TicketStatus ticketStatus;

    @Enumerated(EnumType.STRING)  // Persist Priority as a string
    private Priority priority;

    public TicketEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public IssueEntity getIssue() {
        return issue;
    }

    public void setIssue(IssueEntity issue) {
        this.issue = issue;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
