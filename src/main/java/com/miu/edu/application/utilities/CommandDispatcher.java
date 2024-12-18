package com.miu.edu.application.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CommandDispatcher {

    private final Map<Class<? extends Command>, CommandHandler<?>> handlers;

    @Autowired
    public CommandDispatcher(Map<Class<? extends Command>, CommandHandler<?>> handlers) {
        this.handlers = handlers;
    }

    public <T extends Command> void dispatch(T command) {
        CommandHandler<T> handler = (CommandHandler<T>) handlers.get(command.getClass());

        if (handler != null) {
            handler.handle(command);
        } else {
            throw new IllegalArgumentException("No handler found for command: " + command.getClass().getSimpleName());
        }
    }
}
