package test.bt2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Worker implements Comparable<Worker>{
    private String id;
    private String name;
    private LocalTime in;
    private LocalTime out;


    public Worker(String id, String name, String in, String out) {
        this.id = id;
        this.name = name;
        this.in = LocalTime.parse(in, DateTimeFormatter.ofPattern("HH:mm"));
        this.out = LocalTime.parse(out, DateTimeFormatter.ofPattern("HH:mm"));
    }

    private String getWorkTime() {
        LocalTime x1 = out.minusHours(in.getHour())
                .minusMinutes(in.getMinute());
        return (x1.getHour() - 1) + " gio " + x1.getMinute() + " phut";
    }

    private String status() {
        int hour = out.minusHours(in.getHour()).getHour() - 1;
        if(hour >= 8) {
            return "DU";
        }
        return "THIEU";
    }


    @Override
    public int compareTo(Worker o) {
        LocalTime x1 = out.minusHours(in.getHour())
                .minusMinutes(in.getMinute());

        LocalTime x2 = o.out.minusHours(o.in.getHour())
                .minusMinutes(o.in.getMinute());

        if(x1.compareTo(x2) == 0) {
            return id.compareTo(o.id);
        }
        return x2.compareTo(x1);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getWorkTime() + " " + status();
    }
}
