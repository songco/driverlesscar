package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public class MoveForwardCommand implements Command {

    @Override
    public void moveForward(Car car) throws CarException {
        car.moveForward();
    }

    @Override
    public Set<String> getNameAlias() {
        return Set.of("Move", "MoveForward", "Move Forward", "Forward", "Go");
    }
}
