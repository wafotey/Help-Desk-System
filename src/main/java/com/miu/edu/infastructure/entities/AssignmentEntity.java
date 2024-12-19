package com.miu.edu.infastructure.entities;

import com.miu.edu.domain.aggregates.ticketAggregate.AssignmentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Assignment")
public class AssignmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generating ID for the entity
    private Long id;  // Unique identifier for the entity

    @Column(nullable = false)  // Ensuring that the field is not null
    private int assignedBy;

    @Column(nullable = false)  // Ensuring that the field is not null
    private int assignedTo;

    @Column(name = "ticket_id", nullable = false)  // Ensuring that the field is not null
    private int ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", insertable = false, updatable = false)
    private TicketEntity ticket;

    private LocalDateTime startedAt;

    @Enumerated(EnumType.STRING)  // Mapping the Enum to a string value in the DB
    private AssignmentStatus status = AssignmentStatus.PENDING;  // Default value

    @Embedded
    private ResponseTimeEntity responseTime;  // Assuming ResponseTime is another JPA entity

    // Constructor for JPA entity
    protected AssignmentEntity() {}

    // Constructor with required fields (optional)
    public AssignmentEntity(int assignedTo, int assignedBy, int ticketId, ResponseTimeEntity responseTime) {
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
        this.ticketId = ticketId;
        this.responseTime = responseTime;
        this.status = AssignmentStatus.PENDING;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(int assignedBy) {
        this.assignedBy = assignedBy;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public ResponseTimeEntity getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(ResponseTimeEntity responseTime) {
        this.responseTime = responseTime;
    }
}
