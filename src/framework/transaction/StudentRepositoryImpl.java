package framework.transaction;

import framework.transaction.table.Table;

import java.util.List;
import java.util.Optional;

@DAO(beanName = "studentRepository")
public class StudentRepositoryImpl implements StudentRepository{
    @Override
    public void save(Student student) {
        Table.STUDENTS.add(student);
    }
    @Override
    public void delete(String s) {
        Optional<Student> first = Table.STUDENTS.stream()
                .filter(st -> st.getId().compareTo(s) == 0)
                .findFirst();
        if(first.isPresent()) {
            Table.STUDENTS.remove(first.get());
        }
    }

    @Override
    public List<Student> findAll() {
        return Table.STUDENTS;
    }

    @Override
    public Student findById(String s) {
        return Table.STUDENTS.stream().filter(st -> st.getId().compareTo(s) == 0)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + s));
    }
}
