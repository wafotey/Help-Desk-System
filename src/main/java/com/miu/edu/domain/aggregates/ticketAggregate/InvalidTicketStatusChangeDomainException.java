package com.miu.edu.domain.aggregates.ticketAggregate;

public class InvalidTicketStatusChangeDomainException extends RuntimeException {

    public InvalidTicketStatusChangeDomainException(String message) {
        super(message);
    }

    // Constructor that accepts an error message and a cause
    public InvalidTicketStatusChangeDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}