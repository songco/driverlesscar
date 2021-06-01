package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public interface Command {
    void execute(Car car) throws CarException;

    Set<String> getNameAlias();

    String getName();

    String getDescription();
}
