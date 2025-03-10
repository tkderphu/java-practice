package test.bt3;

public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String classId;
    private String email;
    private String phoneNumber;

    public Student(String id, String name, String classId, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.classId = classId;
        this.email = email;
        this.phoneNumber = "0" + phoneNumber;
    }

    @Override
    public int compareTo(Student o) {
        if(classId.compareTo(o.classId) == 0) {
            return id.compareTo(o.id);
        }
        return classId.compareTo(o.classId);
    }

    @Override
    public String toString() {
        return id + " " + name + " " +classId + " " + email + " " + phoneNumber;
    }
}
