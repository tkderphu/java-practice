package design_pattern.behavioral.mediator;

public class Student {
    private String fullName;

    public Student(String fullName) {
        this.fullName = fullName;
    }
    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
