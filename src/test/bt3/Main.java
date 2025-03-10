package test.bt3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("DANHSACH.in"));
        List<Student> students = new ArrayList<>();
        while(scanner.hasNextLine()) {
            students.add(new Student(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine()
            ));
        }
        Collections.sort(students);
        students.forEach((s) -> {
            System.out.println(s);
        });
    }
}
