package com.miu.edu.application.utilities;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}

