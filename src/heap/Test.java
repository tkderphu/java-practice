package heap;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@FunctionalInterface
interface Function {
    void method(Integer a);
}
class ListNumber {
    private List<Integer> numbers;

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void forEach(Function function) {
        for(int x : numbers) {
            function.method(x);
        }
    }
}

class Student {
    Long id;
    String username;

    public Student(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}

public class Test {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1l, "quangphu"));
        students.add(new Student(2l, "mahiru"));
        students.add(new Student(3l, "hachiman"));
        String json = students.stream().filter(student -> student.username.length() > 7)
                .map(student -> {
                    return "{\n\"Fraction\": " + "\n\t\"id\":" + student.id + ",\n\t\"username\":" + student.username +
                            "\n}\n";
                }).collect(Collectors.joining("\n"));
        System.out.println(json);
    }
}
