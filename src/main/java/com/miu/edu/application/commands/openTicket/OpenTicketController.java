package com.miu.edu.application.commands.openTicket;

import com.miu.edu.application.utilities.CommandDispatcher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class OpenTicketController {
    private final ModelMapper modelMapper;
    private final CommandDispatcher commandDispatcher;

    @Autowired
    public OpenTicketController(CommandDispatcher commandDispatcher, ModelMapper modelMapper) {
        this.commandDispatcher = commandDispatcher;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/open")
    public void openTicket(@RequestBody OpenTicketDto openTicketDto) {
        OpenTicketCommand command = modelMapper.map(openTicketDto, OpenTicketCommand.class);
        this.commandDispatcher.dispatch(command);
    }
}
