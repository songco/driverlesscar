package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class MultiCommand implements Command {
    private final List<Command> commands;

    public MultiCommand(Command... cmd) {
        this.commands = Arrays.stream(cmd).collect(Collectors.toList());
    }

    @Override
    public void execute(Car car) throws CarException {
        for (Command cmd : commands) {
            cmd.execute(car);
        }
    }

    @Override
    public abstract Set<String> getNameAlias();
}
