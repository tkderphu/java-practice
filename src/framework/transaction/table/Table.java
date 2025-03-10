package framework.transaction.table;

import framework.transaction.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
    public static final List<Student> STUDENTS = new ArrayList<>(List.of(
            new Student("1", "1", 1.1),
            new Student("2", "1", 1.1),
            new Student("3", "1", 1.1),
            new Student("4", "1", 1.1)
    ));
}
