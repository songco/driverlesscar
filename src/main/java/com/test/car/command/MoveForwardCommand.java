package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public class MoveForwardCommand implements Command {

    @Override
    public void execute(Car car) throws CarException {
        car.moveForward();
    }

    @Override
    public Set<String> getNameAlias() {
        return Set.of("Move", "MoveForward", "Move Forward", "Go");
    }

    @Override
    public String getName() {
        return "Forward";
    }

    @Override
    public String getDescription() {
        return "Move car forward for 1 step";
    }
}
