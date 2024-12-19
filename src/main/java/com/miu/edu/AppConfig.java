package com.miu.edu;

import com.miu.edu.application.commands.createCustomer.CreateCustomerCommand;
import com.miu.edu.application.commands.openTicket.OpenTicketCommand;
import com.miu.edu.application.utilities.Command;
import com.miu.edu.application.utilities.CommandHandler;
import com.miu.edu.domain.aggregates.customerAggregate.Address;
import com.miu.edu.domain.aggregates.customerAggregate.Customer;
import com.miu.edu.domain.aggregates.ticketAggregate.Issue;
import com.miu.edu.domain.aggregates.ticketAggregate.Ticket;
import com.miu.edu.infastructure.entities.AddressEntity;
import com.miu.edu.infastructure.entities.CustomerEntity;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Configuration
//@ComponentScan(basePackages = "com.miu.edu") // Adjust the base package as needed
//public class AppConfig {
//    @Bean
//    public Map<Class<? extends Command>, CommandHandler<? extends Command>> handlersMap(ApplicationContext context) {
//        Map<Class<? extends Command>, CommandHandler<? extends Command>> map = new HashMap<>();
//        Map<String, CommandHandler> beansOfType = context.getBeansOfType(CommandHandler.class);
//
//        beansOfType.values().forEach(handler -> {
//            Class<? extends Command> commandType = getCommandType(handler);
//            if (commandType != null) {
//                map.put(commandType, handler);
//            }
//        });
//
//        return map;
//    }
//
//    private Class<? extends Command> getCommandType(CommandHandler<? extends Command> handler) {
//        ParameterizedType type = (ParameterizedType) handler.getClass().getGenericInterfaces()[0];
//        return (Class<? extends Command>) type.getActualTypeArguments()[0];
//    }
//    @Bean
//    public ModelMapper modelMapper() {
//        return new ModelMapper();
//    }
//}

@Configuration
@ComponentScan(basePackages = "com.miu.edu")
public class AppConfig {

    @Bean
    public Map<Class<? extends Command>, CommandHandler<? extends Command>> handlersMap(List<CommandHandler<?>> handlers) {
        Map<Class<? extends Command>, CommandHandler<? extends Command>> map = new HashMap<>();
        for (CommandHandler<?> handler : handlers) {
            Class<? extends Command> commandType = getCommandType(handler);
            if (commandType != null) {
                map.put(commandType, handler);
            }
        }
        return map;
    }

    private Class<? extends Command> getCommandType(CommandHandler<?> handler) {
        // Extract the command type from the generic interface of the handler
        ParameterizedType type = (ParameterizedType) handler.getClass().getGenericInterfaces()[0];
        return (Class<? extends Command>) type.getActualTypeArguments()[0];
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Converter for CreateCustomerCommand -> Customer
        modelMapper.addConverter(new Converter<CreateCustomerCommand, Customer>() {
            public Customer convert(MappingContext<CreateCustomerCommand, Customer> context) {
                CreateCustomerCommand source = context.getSource();
                return new Customer(
                        source.getFirstName(),
                        source.getLastName(),
                        source.getEmail(),
                        source.getPhoneNumber(),
                        new Address(
                                source.getStreet(),
                                source.getCity(),
                                source.getState(),
                                source.getZip(),
                                source.getCountry())
                );
            }
        });

        // Converter for Customer -> CustomerEntity
        modelMapper.addConverter(new Converter<Customer, CustomerEntity>() {
            public CustomerEntity convert(MappingContext<Customer, CustomerEntity> context) {
                Customer source = context.getSource();
                return new CustomerEntity(
                        source.getFirstName(),
                        source.getLastName(),
                        source.getEmail(),
                        source.getPhoneNumber(),
                        new AddressEntity(source.getAddress().getStreet(),source.getAddress().getCity(), source.getAddress().getState(),source.getAddress().getZip(),source.getAddress().getCountry()));
            }
        });

        modelMapper.addConverter(new Converter<OpenTicketCommand, Ticket>() {
            public Ticket convert(MappingContext<OpenTicketCommand, Ticket> context) {
                OpenTicketCommand source = context.getSource();
                return new Ticket(
                        source.getCustomerId(),
                        new Issue(source.getDescription()));
            }
        });

        return modelMapper;
    }
}
