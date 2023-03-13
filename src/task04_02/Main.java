/*
Design and develop a method that determines how much time has passed since a given date.
Using this method, print to the console how much time has passed since your birthday in a readable form,
for example: "You are 30 years old, 3 months old, 18 days old, 4 hours, 5 minutes and 10 seconds old."
*/
package task04_02;

import java.time.LocalDateTime;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        String textTimeFrom = getTimeFrom(2014, 10, 10);
        System.out.println(textTimeFrom);
    }

    private static String getTimeFrom(int year, int month, int day) {
        String textData = "";

        LocalDateTime bData = LocalDateTime.of(year, month, day, 0, 0, 0);
        LocalDateTime nData = LocalDateTime.now();

        Period period = Period.between(bData.toLocalDate(), nData.toLocalDate());

        textData = String.format("%d year, %d month, %d day, %d hour, %d min",
                period.getYears(), period.getMonths(), period.getDays(),
                nData.getHour() - bData.getHour(),
                nData.getMinute() - bData.getMinute());

        return textData;
    }
}