package com.test.car.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    void testParkingLotSize() {
        ParkingLot pl = ParkingLot.getParkingLot(4);
        Assertions.assertTrue(pl.contains(1, 1));
        Assertions.assertTrue(pl.contains(4, 4));
        Assertions.assertTrue(pl.contains(4, 1));
        Assertions.assertTrue(pl.contains(1, 4));

        Assertions.assertFalse(pl.contains(0, 0));
        Assertions.assertFalse(pl.contains(1, 0));
        Assertions.assertFalse(pl.contains(0, 1));
        Assertions.assertFalse(pl.contains(4, 5));
        Assertions.assertFalse(pl.contains(5, 4));
        Assertions.assertFalse(pl.contains(1, 5));
        Assertions.assertFalse(pl.contains(5, 1));
    }
}
