package com.miu.edu.domain.aggregates.ticketAggregate;

public enum Priority {

    LOW("Low priority, can be addressed later") {
        @Override
        public Priority next() {
            return MEDIUM;
        }
    },

    MEDIUM("Medium priority, needs attention soon") {
        @Override
        public Priority next() {
            return HIGH;
        }
    },

    HIGH("High priority, needs immediate attention") {
        @Override
        public Priority next() {
            return URGENT;
        }
    },

    URGENT("Urgent priority, requires immediate action") {
        @Override
        public Priority next() {
            return this; // No higher priority than URGENT
        }
    };

    private final String description;

    // Constructor for each enum constant
    Priority(String description) {
        this.description = description;
    }

    // Abstract method for getting the next priority level
    public abstract Priority next();

    // Getter method for the description
    public String getDescription() {
        return description;
    }

    // Utility method to check if a priority is higher than another
    public boolean isHigherThan(Priority other) {
        return this.ordinal() > other.ordinal();
    }

    // Override toString method to give a formatted string
    @Override
    public String toString() {
        return this.name() + ": " + description;
    }
}
