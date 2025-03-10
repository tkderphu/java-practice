package code_ptit.practice;

public class Student {
    private String id;
    private String name;
    private Double gpa;
    private int cultivation;

    public Student(int id, String name, double gpa, int cultivation) {
        this.id = String.format("SV%02d", id);
        this.name = name;
        this.gpa = gpa;
        this.cultivation = cultivation;
    }

    public String receivedScholarship() {
        if(gpa >= 3.6 && cultivation >=90) {
            return "XUATSAC";
        } else if(gpa >= 3.2 && cultivation >= 80) {
            return "GIOI";
        } else if(gpa >= 2.5 && cultivation >= 70) {
            return "KHA";
        } else {
            return "KHONG";
        }
    }

    public Double getGpa() {
        return gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
