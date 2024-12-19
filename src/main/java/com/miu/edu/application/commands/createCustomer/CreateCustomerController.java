package com.miu.edu.application.commands.createCustomer;

import com.miu.edu.application.utilities.CommandDispatcher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CreateCustomerController {
    private final ModelMapper modelMapper;
    private final CommandDispatcher commandDispatcher;

    @Autowired
    public CreateCustomerController(CommandDispatcher commandDispatcher,ModelMapper modelMapper) {
        this.commandDispatcher = commandDispatcher;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create")
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        CreateCustomerCommand command = modelMapper.map(createCustomerDto, CreateCustomerCommand.class);
        commandDispatcher.dispatch(command);
    }
}
