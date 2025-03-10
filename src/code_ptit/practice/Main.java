package code_ptit.practice;

import design_pattern.dyamic_proxy.dyamic.Student;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Date date = ofDate(now);
        System.out.println(now);
        System.out.println(date);
    }
    public static Date ofDate(LocalDateTime d) {
        ZonedDateTime zone = d.atZone(ZoneId.systemDefault());
        Instant instant = zone.toInstant();
        return Date.from(instant);
    }
}
