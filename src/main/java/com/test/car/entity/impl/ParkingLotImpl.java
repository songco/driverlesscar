package com.test.car.entity.impl;

import com.test.car.entity.ParkingLot;
import lombok.Data;

@Data
public class ParkingLotImpl implements ParkingLot {
    private final int x;
    private final int y;

    public ParkingLotImpl(int x, int y) {
        this.x = x;
        this.y = y;
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException("parking lot must greater than (1, 1)");
        }
    }

    public boolean contains(int x, int y) {
        return x > 0 && y > 0 && x <= this.x && y <= this.y;
    }

    public String toString() {
        return String.format("ParkingLot(%2d, %2d)", x, y);
    }
}
