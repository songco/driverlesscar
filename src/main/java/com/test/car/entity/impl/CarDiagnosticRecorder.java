package com.test.car.entity.impl;

import com.test.car.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

public class CarDiagnosticRecorder {
    private static final int MAX_RECODS = 1000;
    private final List<Record> records = new LinkedList<Record>();

    public void audit(String command, Car car, String msg) {
        Record rec = new Record(command, car.toString(), System.currentTimeMillis(), msg);
        records.add(rec);
        if (records.size() > MAX_RECODS) {
            records.remove(0);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car Diagnostic Record\n");
        records.forEach(r -> {
            sb.append("    ").append(r).append("\n");
        });
        return sb.toString();
    }

    @Data
    @AllArgsConstructor
    static class Record {
        private String command;
        private String state;
        private long time;
        private String msg;

        public String toString() {

            return String.format("%s - CMD: %10s -> State: %s, %s", Instant.ofEpochMilli(time),
                    command, state, msg);
        }
    }
}
