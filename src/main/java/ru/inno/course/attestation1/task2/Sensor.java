package ru.inno.course.attestation1.task2;

import java.util.Objects;

public class Sensor {

    private int sensorData = (int) (Math.random() * 101); //диапазон [0;100] формула для диапазана включительно (int) Math.random() * (max - min + 1) + min;

    public Sensor() {
    }

    public Sensor(int sensorData) {
        this.sensorData = sensorData;
    }

    public int getSensorData() {
        return sensorData;
    }

    public void setSensorData(int sensorData) {
        this.sensorData = sensorData;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensor sensor = (Sensor) o;
        return sensorData == sensor.sensorData;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorData);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorData=" + sensorData +
                '}';
    }

}

