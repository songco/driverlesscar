package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public class TurnRightCommand implements Command {

    @Override
    public void turnRight(Car car) throws CarException {
        car.turnRight();
    }

    public Set<String> getNameAlias() {
        return Set.of("Turn", "TurnRight", "Turn Right", "Clockwise", "Right");
    }
}
