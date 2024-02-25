package ru.inno.course.attestation1.task2;

import java.time.LocalDate;

public class Playground {
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        int todaySensor = sensor.getSensorData();
        System.out.println("Сегодня " + LocalDate.now());
        WateringProgram wateringProgram = new WateringProgram();
        System.out.println("Влажность почвы сегодня " + wateringProgram.getHumidity() + "%");
        // Ввод даты последнего полива
        LocalDate lastWateringDate = LocalDate.of(2024, 2, 11);

        LocalDate result = wateringProgram.showNextWateringDate(lastWateringDate);
        System.out.println("Дата следующего полива " + result);
    }
}
