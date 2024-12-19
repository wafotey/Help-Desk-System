package com.miu.edu.application.commands.openTicket;

public class OpenTicketDto {
    private String description;
    private int customerId;
    // Default constructor
    public OpenTicketDto() {}

    // Constructor with parameters
    public OpenTicketDto(String description) {
        this.description = description;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
