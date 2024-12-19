package com.miu.edu.domain.aggregates.ticketAggregate;

public class Question extends Message{
    private int ticketId;
    private Question(){}

    public Question(int ticketId,String question) {
        this.ticketId = ticketId;
        this.description = question;
    }
}