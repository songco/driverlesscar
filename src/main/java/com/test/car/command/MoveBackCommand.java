package com.test.car.command;

import com.test.car.entity.Car;
import com.test.car.exception.CarException;

import java.util.Set;

public class MoveBackCommand implements Command {

    @Override
    public void execute(Car car) throws CarException {
        car.moveBack();
    }

    @Override
    public Set<String> getNameAlias() {
        return Set.of("MoveBack", "Move Back");
    }

    @Override
    public String getName() {
        return "Back";
    }

    @Override
    public String getDescription() {
        return "Move car back for 1 step";
    }
}
