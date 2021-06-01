package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public class TurnLeftCommand implements Command {

    @Override
    public void execute(Car car) throws CarException {
        car.turnLeft();
    }

    public Set<String> getNameAlias() {
        return Set.of("TurnLeft", "Turn Left", "CounterClockwise");
    }

    @Override
    public String getName() {
        return "Left";
    }

    @Override
    public String getDescription() {
        return "Turn car left";
    }
}
