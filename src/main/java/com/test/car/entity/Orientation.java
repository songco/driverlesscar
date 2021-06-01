package com.test.car.entity;

import java.util.Arrays;

public enum Orientation {
    North(1),
    East(2),
    South(3),
    West(4);

    private final int id;

    private static final Orientation[] nextArray = new Orientation[]{West, North, East, South, West, North};
    private int[] offsetArray = new int[]{0, 0, 1, 0, -1, 0};

    Orientation(int id) {
        this.id = id;
    }

    public int getOffsetX() {
        return offsetArray[id];
    }

    public int getOffsetY() {
        return offsetArray[id + 1];
    }

    public Orientation turnRight() {
        return nextArray[id + 1];
    }

    public Orientation turnLeft() {
        return nextArray[id - 1];
    }

    public static Orientation of(String orientation) {
        return Arrays.stream(Orientation.values())
                .filter(o -> o.name().equalsIgnoreCase(orientation)
                        || o.name().substring(0, 1).equalsIgnoreCase(orientation))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
