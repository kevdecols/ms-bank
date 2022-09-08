package com.techBank.account.cmd.infrastructure;

import com.techBank.crqrs.core.commands.BaseCommand;
import com.techBank.crqrs.core.commands.CommandHandlerMethod;
import com.techBank.crqrs.core.infrastructure.CommandDispatcher;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AccountCommandDispatcher implements CommandDispatcher {
    private final Map<Class<? extends BaseCommand>, List<CommandHandlerMethod>> routes = new HashMap<>();

    @Override
    public <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler) {
        var handlers = routes.computeIfAbsent(type, c -> new LinkedList<>());
        handlers.add(handler);
    }

    @Override
    public void send(BaseCommand command) {
        var handlers = routes.get(command.getClass());
        if (handlers== null || handlers.size()==0)  {
            throw new RuntimeException("No handlers registered for commands");
        }
        if(handlers.size()>1){
            throw new RuntimeException("Multiple handlers registered for commands");
        }
        handlers.get(0).handle(command);
    }
}
