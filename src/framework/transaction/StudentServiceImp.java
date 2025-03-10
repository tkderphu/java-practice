package framework.transaction;


public class StudentServiceImp implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student findById(String id) {
        return null;
    }
}
