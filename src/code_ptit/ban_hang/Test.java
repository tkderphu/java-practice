package code_ptit.ban_hang;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date now = new Date(System.currentTimeMillis());
        Date date = buildDate(2024, 9, 26, 21, 0, 0);
        System.out.println(now);
        System.out.println(date);
        Date distance = new Date(now.getTime() - date.getTime());
        Calendar instance = Calendar.getInstance();
        instance.setTime(distance);
        System.out.println(instance.get(Calendar.YEAR));
    }

    public static Date buildDate(int year, int month, int day,
                                 int hours, int minutes, int seconds) {
        Calendar instance = Calendar.getInstance();
        instance.set(year, month, day, hours, minutes, seconds);
//        instance.set(Calendar.YEAR, year);
//        instance.set(Calendar.MONTH, month);
//        instance.set(Calendar.DAY_OF_MONTH, day);
//        instance.set(Calendar.HOUR_OF_DAY, hours);
//        instance.set(Calendar.MINUTE, minutes);
//        instance.set(Calendar.SECOND, seconds);
        return instance.getTime();
    }
}
