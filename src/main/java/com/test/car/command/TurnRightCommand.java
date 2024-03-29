package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public class TurnRightCommand implements Command {

    @Override
    public void execute(Car car) throws CarException {
        car.turnRight();
    }

    public Set<String> getNameAlias() {
        return Set.of("TurnRight", "Turn Right", "Clockwise");
    }

    @Override
    public String getName() {
        return "Right";
    }

    @Override
    public String getDescription() {
        return "Turn car right";
    }
}
