package code_ptit.practice.monhoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        Map<String, Boolean> lookups = new HashMap<>();
        ArrayList<Subject> subjects = new ArrayList<>();
        while(sc.hasNextLine()) {
            String subjectId = sc.nextLine();
            String subjectName = sc.nextLine();
            String testFormat = sc.nextLine();
            if(!lookups.containsKey(subjectId)) {
                lookups.put(subjectId, true);
                subjects.add(new Subject(subjectId, subjectName, testFormat));
            }
        }
        Collections.sort(subjects);
        subjects.forEach(s -> System.out.println(s));
    }
}
