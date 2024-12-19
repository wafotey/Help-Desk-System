package com.miu.edu.domain.aggregates.ticketAggregate;

import com.miu.edu.domain.aggregates.assignmentAggregate.Assignment;
import com.miu.edu.domain.shared.AggregateRoot;
import com.miu.edu.domain.shared.Entity;

import java.util.ArrayList;
import java.util.List;
public class Ticket extends Entity implements AggregateRoot {

    private int customerId;
    private Issue issue;
    private List<Message> messages;
    private TicketStatus ticketStatus;
    private Priority priority;
    private Assignment assignment;

    protected Ticket() {
        messages = new ArrayList<>();
    }

    public Ticket(int customerId, Issue issue) {
        this.customerId = customerId;
        messages = new ArrayList<>();
        this.issue = issue;
        this.ticketStatus = TicketStatus.OPENED;
    }



    public void append(Question question) {
        this.messages.add(question);
    }

    public void append(Answer answer) {
        this.messages.add(answer);
    }

    public void change(Priority priority) {
        this.priority = priority;
        if(priority == Priority.URGENT) {
            addDomainEvent(new PriorityChangedDomainEvent(assignment, priority));
        }
    }

    public int getCustomerId() {
        return customerId;
    }

    public Issue getIssue() {
        return issue;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public Priority getPriority() {
        return priority;
    }

    public Assignment getAssignment() {
        return assignment;
    }
}
