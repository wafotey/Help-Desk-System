package com.miu.edu.domain.aggregates.ticketAggregate;

import com.miu.edu.domain.shared.Entity;

public abstract class Message extends Entity {
    public String description;

    public String getDescription() {
        return description;
    }
}
