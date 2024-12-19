package com.miu.edu.application.commands.openTicket;

import com.miu.edu.application.utilities.Command;

public class OpenTicketCommand implements Command {
    private String description;
    private int customerId;

    // Default constructor
    public OpenTicketCommand() {}

    // Constructor with parameters
    public OpenTicketCommand(int customerId,String description) {
        this.customerId = customerId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

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