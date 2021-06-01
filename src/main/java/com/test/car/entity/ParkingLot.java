package com.test.car.entity;

import com.test.car.entity.impl.ParkingLotImpl;

public interface ParkingLot {
    static ParkingLot getDefault() {
        return getParkingLot(4);
    }

    static ParkingLot getParkingLot(int size) {
        return getParkingLot(size, size);
    }

    static ParkingLot getParkingLot(int x, int y) {
        return new ParkingLotImpl(x, y);
    }

    boolean contains(int x, int y);

    default boolean contains(Car car) {
        return contains(car.getPositionX(), car.getPositionY());
    }
}
