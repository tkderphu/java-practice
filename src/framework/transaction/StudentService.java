package framework.transaction;

public interface StudentService {
    void save(Student student);
    Student findById(String id);

}
