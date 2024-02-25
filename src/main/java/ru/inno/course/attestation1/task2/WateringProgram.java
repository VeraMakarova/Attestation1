package ru.inno.course.attestation1.task2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class WateringProgram {
    LocalDate today = LocalDate.now();
    int testHumidity = 59; // эта переменная не нужна в основной программе, использовалась только для проверски
    private Sensor programSensor = new Sensor();
    private int humidity = programSensor.getSensorData(); //показания датчика влажности

    public WateringProgram(LocalDate today, int testHumidity, Sensor programSensor, int humidity) {
        this.today = today;
        this.testHumidity = testHumidity;
        this.programSensor = programSensor;
        this.humidity = humidity;
    }
    //____________________________________________________

    public LocalDate showNextWateringDate(LocalDate lastWateringDate) {
        LocalDate nextWateringDate;
        long daysBetween = ChronoUnit.DAYS.between(lastWateringDate, today); // сколько прошло дней с последнего полива
        int monthValue = today.getMonthValue();
        System.out.println("Дата прошлого полива " + lastWateringDate);
        //  1. если введена неправильная дата, будущее время
        if (daysBetween < 0) {
            nextWateringDate = null;
            System.out.println("Введите корректную дату последнего полива");
        }

        // 2. кактус нельзя поливать чаще, чем раз в два дня. Если полив был сегодня или вчера, полить через два дня после даты последнего полива
        else if (daysBetween == 0 || daysBetween == 1) {
            nextWateringDate = lastWateringDate.plusDays(2);
            System.out.println("Вы недавно уже поливали кактус");
        }

        //  3. Если влажность меньше 30%, кактус нужно полить сегодня
        else if (humidity < 30) {
            nextWateringDate = today;
            System.out.println("Влажность почвы ниже допустимой. Кактус надо полить сегодня");
        }
        // 4. Самая редкая частота полива - раз в месяц. Если кактус не поливался больше месяца (например 3 года), его надо полить сегодня
        else if (daysBetween > 30) {
            nextWateringDate = today;
            System.out.println("Прошло дней с прошлого полива  " + daysBetween + ". Кактус надо полить сегодня");
        }
        //5. если зима - полив раз в месяц
        else if (monthValue == 1 || monthValue == 2 || monthValue == 12) {
            nextWateringDate = lastWateringDate.plusMonths(1);
            System.out.println("Зимой кактус надо поливать раз в месяц");
        }
        // 6. если лето, полить через 3 дня
        else if (monthValue == 6 || monthValue == 7 || monthValue == 8) {
            nextWateringDate = lastWateringDate.plusDays(2);
        }
        //7. Осень или весна - полив раз в неделю. Если больше 7 дней прошло, кактус надо полить сегодня
        else if (daysBetween > 7) {
            nextWateringDate = today;
            System.out.println("Весной и осенью кактус следует поливать раз в неделю. Прошло дней с прошлого полива  " + daysBetween + ". Кактус надо полить сегодня");
        }
        //8. Осень или весна, с полива прошло менее 7 дней, полить через неделю после последнего прлива
        else {
            nextWateringDate = lastWateringDate.plusDays(7);
            System.out.println("Весной и осенью кактус следует поливать раз в неделю");
        }
        return nextWateringDate;
    }
//___________________________________________

    public WateringProgram() {
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }


    public int getTestHumidity() {
        return testHumidity;
    }

    public void setTestHumidity(int testHumidity) {
        this.testHumidity = testHumidity;
    }

    public Sensor getProgramSensor() {
        return programSensor;
    }

    public void setProgramSensor(Sensor programSensor) {
        this.programSensor = programSensor;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WateringProgram that = (WateringProgram) o;
        return testHumidity == that.testHumidity && humidity == that.humidity && Objects.equals(today, that.today) && Objects.equals(programSensor, that.programSensor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(today, testHumidity, programSensor, humidity);
    }

    @Override
    public String toString() {
        return "WateringProgram{" +
                "today=" + today +
                ", testHumidity=" + testHumidity +
                ", programSensor=" + programSensor +
                ", humudity=" + humidity +
                '}';
    }
}

