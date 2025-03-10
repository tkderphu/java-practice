package code_ptit.practice.luyentap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("HOIDONG.in"));
        int x = Integer.parseInt(sc.nextLine());
        ArrayList<Student> students = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            String fullName = sc.nextLine();
            String words[] = sc.nextLine().split("\\s+");
            students.add(new Student(fullName, Integer.parseInt(words[0]), Integer.parseInt(words[1])));
        }
        Collections.sort(students);
        students.forEach(s -> System.out.println(s));
    }
}
