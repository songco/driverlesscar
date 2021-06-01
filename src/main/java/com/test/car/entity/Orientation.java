package com.test.car.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Orientation {
    North(0, 1),
    East(1, 0),
    South(0, -1),
    West(-1, 0);

    private int id;
    private int offsetX;
    private int offsetY;

    private static final Map<Orientation, Orientation> nextMap = new HashMap<>(4);

    static {
        nextMap.put(North, East);
        nextMap.put(East, South);
        nextMap.put(South, West);
        nextMap.put(West, North);
    }

    Orientation(int xOffset, int yOffset) {
        this.offsetX = xOffset;
        this.offsetY = yOffset;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public Orientation clockwiseNext() {
        return nextMap.get(this);
    }

    public static Orientation of(String orientation) {
        return Arrays.stream(Orientation.values())
                .filter(o -> o.name().equalsIgnoreCase(orientation)
                        || o.name().substring(0, 1).equalsIgnoreCase(orientation))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
