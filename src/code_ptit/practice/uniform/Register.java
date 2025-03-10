package code_ptit.practice.uniform;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private List<Student> students;
    private String size;

    public Register(String size) {
        this.size = size;
    }

    public void addRecord(Student student) {
        if(this.students == null) this.students = new ArrayList<>();
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
