package test.bt5;

public class Teaching {
    private Teacher teacher;
    private Subject subject;
    private double hours;

    public Teaching(Teacher teacher, Subject subject, double hours) {
        this.teacher = teacher;
        this.subject = subject;
        this.hours = hours;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getHours() {
        return hours;
    }
}
