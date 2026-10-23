package br.com.dio.offsetdatetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class OffSetDateTimeLesson {
    public static void main(String[] args) {
        System.out.println("===LocalDate===");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(formatter.format(localDate));

        var strDate = "18/10/1988";
        var newLocalDate = LocalDate.parse(strDate, formatter);
        System.out.println(formatter.format(newLocalDate));

        var localDate3 = newLocalDate.plus(38, ChronoUnit.YEARS);
        System.out.println(formatter.format(localDate3));
        System.out.println(formatter.format(localDate3.minusYears(10)));

        System.out.println("===LocalTime===");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(formatter2.format(localTime));

        System.out.println("===LocalDateTime===");
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);

        DateTimeFormatter formatter3 = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println(formatter3.format(localDateTime));

        System.out.println("===OffsetDateTime===");
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println(offsetDateTime);

        OffsetDateTime offsetDateTime2 = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);
        System.out.println(offsetDateTime2);
        System.out.println(offsetDateTime.isEqual(offsetDateTime2));

        System.out.println("===Retrocompatibilidade===");
        Date date = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3)));
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat formatter4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        var stringDate = formatter4.format(calendar.getTime());
        System.out.println(stringDate);

        Date date2 = new Date();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        ZoneId zoneId = calendar2.getTimeZone().toZoneId();
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(calendar.toInstant(), zoneId);
        System.out.println(localDateTime2);
        System.out.println(Duration.between(localDateTime, localDateTime2).toMillis());

        Date date3 = Date.from(offsetDateTime.toInstant());
        Calendar calendar3 = Calendar.getInstance();
        calendar.setTime(date3);
        DateFormat formatter5 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss Z");
        var stringDate2 = formatter5.format(calendar3.getTime());
        System.out.println(stringDate2);

        OffsetDateTime offsetDateTime3 = calendar3.getTime().toInstant().atOffset(ZoneOffset.ofHours(3));
        System.out.println(offsetDateTime3);
    }
}
