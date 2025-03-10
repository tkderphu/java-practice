package code_ptit.practice.uniform;

public class Student implements Comparable<Student>{
    private String id;
    private String name;
    private String className;
    private String email;
    private String phoneNumber;
    private String gender;

    public Student(String id, String name, String className, String email, String phoneNumber, String gender) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + className +" " + email + " " + phoneNumber;
    }

    @Override
    public int compareTo(Student o) {
        return id.compareTo(o.id);
    }
}
