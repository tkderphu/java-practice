package test.bt4;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Report {
    private LocalTime time;
    private Student student;

    public Report(String time, Student student) {
        this.time = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
//        System.out.println(this.time);
        this.student = student;
    }

    public boolean isMorning() {
        return time.getHour() <= 12;
    }


    @Override
    public String toString() {
        String res = time.format(DateTimeFormatter.ofPattern("hh:mm"));
        return student.getId() + " " + student.getName() + " " +student.getTopic() + " " + res;
    }
}
