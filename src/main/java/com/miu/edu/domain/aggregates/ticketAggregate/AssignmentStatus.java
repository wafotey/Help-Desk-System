package com.miu.edu.domain.aggregates.ticketAggregate;

public enum AssignmentStatus {

    PENDING("The assignment is pending submission."),
    IN_PROGRESS("The assignment is currently being worked on."),
    COMPLETED("The assignment has been submitted and is complete."),
    REASSIGNED("The assignment has been reassigned to a different user or group.");

    // Encapsulation: private field to store status description
    private final String description;

    // Constructor to set the description for each enum value
    private AssignmentStatus(String description) {
        this.description = description;
    }

    // Public method to retrieve the description
    public String getDescription() {
        return description;
    }

    // Optional: You could also add custom behavior (e.g., status transitions)
    public boolean isCompleted() {
        return this == COMPLETED;
    }

    // A method to get an enum by name, with case insensitivity if needed
    public static AssignmentStatus fromString(String status) {
        for (AssignmentStatus s : values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("No enum constant for status: " + status);
    }

    @Override
    public String toString() {
        return name() + " - " + description;
    }
}