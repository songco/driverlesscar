package com.test.car.entity;

import com.test.car.entity.impl.CarImpl;
import com.test.car.exception.CarException;

public interface Car {
    void move(String command) throws CarException;

    int getPositionX();

    int getPositionY();

    Orientation getOrientation();

    String diagnosticRecords();

    void moveForward() throws CarException;

    void turnRight() throws CarException;

    static Car getCar(int x, int y, Orientation orientation, int plx, int ply) {
        return new CarImpl(x, y, orientation, ParkingLot.getParkingLot(plx, ply));
    }
}