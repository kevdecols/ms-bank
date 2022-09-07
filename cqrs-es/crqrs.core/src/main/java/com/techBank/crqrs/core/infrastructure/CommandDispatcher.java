package com.techBank.crqrs.core.infrastructure;

import com.techBank.crqrs.core.commands.BaseCommand;
import com.techBank.crqrs.core.commands.CommandHandlerMethod;

public interface CommandDispatcher {
    <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    void send(BaseCommand command);
}
