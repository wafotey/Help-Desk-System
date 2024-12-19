package com.miu.edu.application.commands.openTicket;

import com.miu.edu.application.utilities.CommandHandler;
import com.miu.edu.domain.aggregates.ticketAggregate.Ticket;
import com.miu.edu.domain.aggregates.ticketAggregate.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpenTicketCommandHandler implements CommandHandler<OpenTicketCommand> {

    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OpenTicketCommandHandler(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void handle(OpenTicketCommand command) {
        Ticket ticket = modelMapper.map(command, Ticket.class);
        this.ticketRepository.add(ticket);
    }
}
