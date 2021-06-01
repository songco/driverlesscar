package com.test.car;

import com.test.car.command.Commands;
import com.test.car.entity.Car;
import com.test.car.entity.Orientation;
import com.test.car.entity.ParkingLot;
import com.test.car.entity.impl.CarImpl;
import com.test.car.entity.impl.ParkingLotImpl;
import com.test.car.exception.CarException;
import com.test.car.exception.InvalidCarCommandException;
import com.test.car.exception.InvalidCarStateException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CarTestConsoleRunner {
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        welcome();
        ParkingLot pl = null;
        while (pl == null) {
            parkingLotMessage();
            String line = readLine(reader);
            String[] values = line.trim().split(" ");
            try {
                pl = new ParkingLotImpl(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
            } catch (Exception e) {
                System.out.println("Invalid parking lot size: " + line);
                System.out.println("");
            }
        }

        Car car = null;
        while (car == null) {
            carMessage();
            String line = readLine(reader);
            String[] values = line.trim().split(" ");
            try {
                car = new CarImpl(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Orientation.of(values[2])
                        , pl);
            } catch (Exception e) {
                System.out.println("Invalid car initial state: " + e.getMessage());
                System.out.println("");
            }
        }

        commandMessage();
        while (true) {
            System.out.print("Command:");
            String command = readLine(reader);
            if (command == null) {
                continue;
            }
            if (command.equals("quit")) {
                line();
                System.out.println("Bye~");
                line();
                break;
            }
            try {
                car.move(command);
                System.out.println("Car - " + car.toString());
            } catch (InvalidCarCommandException e) {
                System.out.println("Invalid car command: " + command);
            } catch (InvalidCarStateException e) {
                System.out.println("Car enter invalid state, exit.");
                line();
                break;
            } catch (CarException e) {
                System.out.println("Car exception, exit.");
                break;
            }

        }
        System.out.println(car.diagnosticRecords());
    }

    private String readLine(BufferedReader reader) {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    private void welcome() {
        line();
        System.out.println("*************************************************\n");
        System.out.println("   Welcome driver less car test in parking lot   \n");
        System.out.println("*************************************************\n");

    }

    private void parkingLotMessage() {
        line();
        System.out.println("Input your parking lot size, numbers should greater than 0, two numbers separated by " +
                "space, e.g.:");
        System.out.println("\t `4 5` - parking lot of size 4*5");
        System.out.println("\t `1 1` - parking lot of size 1*1, minimal one");
        System.out.println("Enter your parking lot size:");

    }

    private void carMessage() {
        line();
        System.out.println("Input your car initial status, include initial position and orientation, e.g.:");
        System.out.println("\t `1 1 west` means position (1,1) and orientation is `West`");
        System.out.println("\t `1 2 w` means position (1,2) and orientation is `West`");
        System.out.println("\t `4 4 S` means position (4,4) and orientation is `South`");
        System.out.println("Orientation we supported: " + Arrays.toString(Orientation.values()) + " and E/W/N/S");
        System.out.println("Enter initial position and orientation:");
    }

    private void commandMessage() {
        line();
        System.out.println("Driver less car is ready in parking lot, input your command to move the car.");
        System.out.println("Supported commands(ignore case):");
        Commands.getCommands().forEach(cmd -> {
            System.out.println(String.format("   %-12s  ~  %s, also support alias: %s.", cmd.getName(),
                    cmd.getDescription()
                    , Arrays.toString(cmd.getNameAlias().toArray())));
        });
    }

    private void line() {
        System.out.println("\n--------------------------------------------------");
    }
}
