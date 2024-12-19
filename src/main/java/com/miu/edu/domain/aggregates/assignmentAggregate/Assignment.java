package com.miu.edu.domain.aggregates.assignmentAggregate;

import com.miu.edu.domain.aggregates.ticketAggregate.AssignmentStatus;
import com.miu.edu.domain.shared.AggregateRoot;
import com.miu.edu.domain.shared.Entity;

import java.time.LocalDateTime;

public class Assignment extends Entity implements AggregateRoot {
    public int assignedBy;
    public int assignedTo;
    public int ticketId;
    public LocalDateTime startedAt;
    private AssignmentStatus status;
    public ResponseTime responseTime;

    public Assignment(int assignedTo, int assignedBy, int ticketId, ResponseTime responseTime) {
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
        this.ticketId = ticketId;
        this.responseTime = responseTime;
        this.status = AssignmentStatus.PENDING;
    }

    public int getAssignedBy() {
        return assignedBy;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public int getTicketId() {
        return ticketId;
    }

    public ResponseTime getResponseTime() {
        return responseTime;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public AssignmentStatus getStatus() {
        return status;
    }
}
