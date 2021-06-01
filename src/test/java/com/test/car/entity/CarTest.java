package com.test.car.entity;

import com.test.car.command.Commands;
import com.test.car.exception.CarException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CarTest {
    private static Stream<Arguments> orientationMatrix() {
        return Stream.of(
                Arguments.of(Orientation.North, Orientation.East),
                Arguments.of(Orientation.East, Orientation.South),
                Arguments.of(Orientation.South, Orientation.West),
                Arguments.of(Orientation.West, Orientation.North)

        );
    }

    @ParameterizedTest
    @MethodSource("orientationMatrix")
    void testCarOrientation(Orientation initial, Orientation expected) throws CarException {
        Car car = Car.getCar(1, 1, initial, 1, 1);
        car.move(Commands.CMD_TURN_RIGHT);
        Assertions.assertEquals(expected, car.getOrientation());
    }

    private static Stream<Arguments> moveForwardParams() {
        return Stream.of(
                Arguments.of(1, 1, Orientation.North, 1, 2),
                Arguments.of(1, 1, Orientation.East, 2, 1),
                Arguments.of(4, 4, Orientation.South, 4, 3),
                Arguments.of(4, 3, Orientation.West, 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("moveForwardParams")
    void testCarMoveForwardOneStep(int x, int y, Orientation orientation, int expX, int expY) throws CarException {
        Car car = Car.getCar(x, y, orientation, 4, 4);
        car.move(Commands.CMD_MOVE_FORWARD);
        Assertions.assertEquals(expX, car.getPositionX());
        Assertions.assertEquals(expY, car.getPositionY());
    }

    private static Stream<Arguments> moveForwardTwoStepsParams() {
        return Stream.of(
                Arguments.of(1, 1, Orientation.North, 1, 3),
                Arguments.of(1, 1, Orientation.East, 3, 1),
                Arguments.of(4, 4, Orientation.South, 4, 2),
                Arguments.of(4, 3, Orientation.West, 2, 3)
                );
    }

    @ParameterizedTest
    @MethodSource("moveForwardTwoStepsParams")
    void testCarMoveForwardTwoSteps(int x, int y, Orientation orientation, int expX, int expY) throws CarException {
        Car car = Car.getCar(x, y, orientation, 4, 4);
        car.move(Commands.CMD_MOVE_FORWARD);
        car.move(Commands.CMD_MOVE_FORWARD);
        Assertions.assertEquals(expX, car.getPositionX());
        Assertions.assertEquals(expY, car.getPositionY());
    }

    private static Stream<Arguments> moveExceptionParams() {
        return Stream.of(
                Arguments.of(1, 1, Orientation.West),
                Arguments.of(1, 1, Orientation.South),
                Arguments.of(4, 4, Orientation.North),
                Arguments.of(4, 4, Orientation.East));
    }

    @ParameterizedTest
    @MethodSource("moveExceptionParams")
    void shouldThrowExceptionWhenCarOutsideBoundaries(int x, int y, Orientation orientation) throws CarException {
        Car car = Car.getCar(x, y, orientation, 4, 4);
        Assertions.assertThrows(CarException.class, () -> {
            car.move(Commands.CMD_MOVE_FORWARD);
        });
    }
}
