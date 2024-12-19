package com.miu.edu.domain.aggregates.ticketAggregate;

import com.miu.edu.domain.aggregates.assignmentAggregate.Assignment;
import com.miu.edu.domain.shared.DomainEvent;

public record PriorityChangedDomainEvent(Assignment assignment, Priority priority) implements DomainEvent {
}
