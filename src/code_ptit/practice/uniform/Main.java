package code_ptit.practice.uniform;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner studentInput = new Scanner(new File("SINHVIEN.in"));
        Scanner registerInput = new Scanner(new File("SINHVIEN.in"));
        int numberOfStudent = Integer.parseInt(studentInput.nextLine());
        Map<String, Student> students = new HashMap<>();
        Map<String, Register> registers = new HashMap<>();
        for(int i = 0; i < numberOfStudent; i++) {
            String id = studentInput.nextLine();
            String name = studentInput.nextLine();
            String className = studentInput.nextLine();
            String email = studentInput.nextLine();
            String phoneNumber = studentInput.nextLine();
            String gender = studentInput.nextLine();
            if(!students.containsKey(id)) {
                students.put(id, new Student(id, name, className, email, phoneNumber, gender));
            }
        }
        for(int i = 0; i < numberOfStudent; i++) {
            String[] words = registerInput.nextLine().split("\\s+");
            if(!registers.containsKey(words[1])) {
                registers.put(words[1], new Register(words[1]));
            }
            registers.get(words[1]).addRecord(students.get(words[0]));

        }
        Scanner query = new Scanner(new File("TRUYVAN.in"));
        int numberOfQuery = Integer.parseInt(query.nextLine());
        for(int i = 0; i < numberOfQuery; i++) {
            String[] words = query.nextLine().split("\\s+");
            System.out.println(String.format("DANH SACH SINH VIEN %s DANG KY SIZE %s", words[0].toUpperCase(), words[1].toUpperCase()));
            Register register = registers.get(words[1]);
            Collections.sort(register.getStudents());
            for(Student student : register.getStudents()) {
                if(student.getGender().toLowerCase().compareTo(words[0].toLowerCase()) == 0) {
                    System.out.println(student);
                }
            }

        }

    }
}
