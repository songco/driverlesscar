package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public interface Command {
    default void execute(Car car) throws CarException {
        moveForward(car);
        turnRight(car);
    }

    default void moveForward(Car car) throws CarException {

    }

    default void turnRight(Car car) throws CarException {

    }

    Set<String> getNameAlias();
}
