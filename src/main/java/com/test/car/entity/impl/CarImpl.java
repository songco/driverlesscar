package com.test.car.entity.impl;

import com.test.car.command.Command;
import com.test.car.command.Commands;
import com.test.car.entity.Car;
import com.test.car.entity.Orientation;
import com.test.car.entity.ParkingLot;
import com.test.car.exception.CarException;
import com.test.car.exception.InvalidCarStateException;
import lombok.Data;

@Data
public class CarImpl implements Car {
    private int x;
    private int y;
    private Orientation orientation;
    private ParkingLot parkingLot;
    private final CarDiagnosticRecorder cdr = new CarDiagnosticRecorder();

    public CarImpl() {
        this(1, 1);
    }

    public CarImpl(int x, int y) {
        this(x, y, Orientation.North, ParkingLot.getDefault());
    }

    public CarImpl(int x, int y, Orientation orientation, ParkingLot parkingLot) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.parkingLot = parkingLot;
        if (this.parkingLot.contains(this) && x > 0 && y > 0) {
            cdr.audit("Init", this, "Success");
        } else {
            throw new IllegalArgumentException("parking lot size or car position not valid");
        }
    }


    @Override
    public void move(String command) throws CarException {
        try {
            Command cmd = Commands.of(command);
            cmd.execute(this);
            if (!parkingLot.contains(this)) {
                throw new InvalidCarStateException("Car go out side parking lot");
            }
        } catch (CarException e) {
            cdr.audit(command, this, "Exception-" + e.getMessage());
            throw e;
        }
        cdr.audit(command, this, "Success");
    }

    @Override
    public int getPositionX() {
        return x;
    }

    @Override
    public int getPositionY() {
        return y;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String diagnosticRecords() {
        return cdr.toString();
    }

    @Override
    public void moveForward() throws CarException {
        this.x += orientation.getOffsetX();
        this.y += orientation.getOffsetY();
    }

    @Override
    public void turnRight() throws CarException {
        this.orientation = this.orientation.clockwiseNext();
    }

    public String toString() {
        return String.format("Car(%2d, %2d, %5s), %s", x, y, orientation.name(), parkingLot);
    }
}
