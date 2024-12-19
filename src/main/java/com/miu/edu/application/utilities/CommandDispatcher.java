package com.miu.edu.application.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
public class CommandDispatcher {

    private final Map<Class<? extends Command>, CommandHandler<? extends Command>> handlers;

    @Autowired
    public CommandDispatcher(Map<Class<? extends Command>, CommandHandler<? extends Command>> handlers) {
        this.handlers = handlers;
    }

    //@SuppressWarnings("unchecked")
    @Transactional
    public <T extends Command> void dispatch(T command) {
        CommandHandler<T> handler = (CommandHandler<T>) handlers.get(command.getClass());

        if (handler != null) {
            handler.handle(command);
        } else {
            throw new IllegalArgumentException("No handler found for command: " + command.getClass().getSimpleName());
        }
    }
}



