package com.miu.edu.domain.aggregates.ticketAggregate;


public class Issue extends Message {
    private Issue(){}

    public Issue(String description) {
        this.description = description;
    }
}