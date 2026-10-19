package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLesson {
    public static void main(String[] args) {
        var date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(date);
        System.out.println(formatter.format(date));

        System.out.println("======");
        date = new Date(System.currentTimeMillis() - 99999999999L);
        System.out.println(date);
    }
}
