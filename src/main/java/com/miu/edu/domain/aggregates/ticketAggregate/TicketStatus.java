package com.miu.edu.domain.aggregates.ticketAggregate;

public enum TicketStatus {

    OPENED("Opened", true, false) {
        @Override
        public TicketStatus next() {
            return ESCALATED;  // Can be escalated from opened
        }

        @Override
        public boolean canTransitionTo(TicketStatus nextStatus) {
            return nextStatus == ESCALATED || nextStatus == CLOSED || nextStatus == REOPENED;
        }
    },

    CLOSED("Closed", false, true) {
        @Override
        public TicketStatus next() {
            return REOPENED;  // Can be reopened from closed
        }

        @Override
        public boolean canTransitionTo(TicketStatus nextStatus) {
            return nextStatus == REOPENED;
        }
    },

    ESCALATED("Escalated", true, false) {
        @Override
        public TicketStatus next() {
            return CLOSED;  // After escalation, the ticket can be closed
        }

        @Override
        public boolean canTransitionTo(TicketStatus nextStatus) {
            return nextStatus == CLOSED;
        }
    },

    REOPENED("Reopened", true, false) {
        @Override
        public TicketStatus next() {
            return ESCALATED;  // Reopened tickets can be escalated
        }

        @Override
        public boolean canTransitionTo(TicketStatus nextStatus) {
            return nextStatus == ESCALATED || nextStatus == CLOSED;
        }
    };

    private final String label;
    private final boolean canBeAssigned;
    private final boolean isFinalState;

    TicketStatus(String label, boolean canBeAssigned, boolean isFinalState) {
        this.label = label;
        this.canBeAssigned = canBeAssigned;
        this.isFinalState = isFinalState;
    }

    // Abstract methods to be implemented by each enum constant
    public abstract TicketStatus next();

    public abstract boolean canTransitionTo(TicketStatus nextStatus);

    public String getLabel() {
        return label;
    }

    public boolean canBeAssigned() {
        return canBeAssigned;
    }

    public boolean isFinalState() {
        return isFinalState;
    }

    @Override
    public String toString() {
        return String.format("TicketStatus{label='%s', canBeAssigned=%s, isFinalState=%s}", label, canBeAssigned, isFinalState);
    }

    // Method to attempt a transition and throw a specific exception if it's invalid
    public TicketStatus transitionTo(TicketStatus nextStatus) {
        if (!canTransitionTo(nextStatus)) {
            throw new InvalidTicketStatusChangeDomainException(
                    "Invalid ticket status from " + this.label + " to " + nextStatus.getLabel());
        }
        return nextStatus;
    }
}