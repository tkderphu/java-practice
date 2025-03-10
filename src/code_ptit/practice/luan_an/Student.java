package code_ptit.practice.luan_an;

public class Student {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;

    public Student(String id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

