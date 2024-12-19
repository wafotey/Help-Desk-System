package com.miu.edu.application.commands.createCustomer;

import com.miu.edu.application.utilities.CommandHandler;
import com.miu.edu.domain.aggregates.customerAggregate.Customer;
import com.miu.edu.domain.aggregates.customerAggregate.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCustomerCommandHandler implements CommandHandler<CreateCustomerCommand> {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CreateCustomerCommandHandler(CustomerRepository customerRepository,ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void handle(CreateCustomerCommand command) {
        Customer customer = modelMapper.map(command, Customer.class);
        this.customerRepository.add(customer);
    }
}
