package br.com.dio.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarLesson {
    public static void main(String[] args) throws ParseException {
        var calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        var stringDate = formatter.format(calendar.getTime());
        System.out.println(stringDate);

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 5);
        System.out.println(formatter.format(calendar.getTime()));

        stringDate = stringDate.replace("18:", "21:");
        var newDate = formatter.parse(stringDate);
        var newCalendar = Calendar.getInstance();
        newCalendar.setTime(newDate);
        System.out.println(formatter.format(newCalendar.getTime()));
    }
}
