package test.bt5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner mh = new Scanner(new File("MONHOC.in"));
        Scanner gv = new Scanner(new File("GIANGVIEN.in"));
        Scanner gc = new Scanner(new File("GIOCHUAN.in"));

        Map<String, Subject> subjectMap = new HashMap<>();
        Map<String, Teacher> teacherMap = new LinkedHashMap<>();
        List<Teaching> teachings = new ArrayList<>();

        int num = Integer.parseInt(mh.nextLine());
        while(num -- > 0) {
            String w = mh.nextLine();
            int index = w.indexOf(" ");
            String id = w.substring(0, index);
            String name = w.substring(index + 1);
            subjectMap.put(w.substring(0, index), new Subject(id, name));
        }
        num = Integer.parseInt(gv.nextLine());
        while(num -- > 0) {
            String w = gv.nextLine();
            int index = w.indexOf(" ");
            String id = w.substring(0, index);
            String name = w.substring(index + 1);
            teacherMap.put(id, new Teacher(id, name));
        }
        num = Integer.parseInt(gc.nextLine());
        while(num -- > 0) {
            String words[] = gc.nextLine().split("\\s+");
            teachings.add(new Teaching(
                    teacherMap.get(words[0]),
                    subjectMap.get(words[1]),
                    Double.parseDouble(words[2])
            ));
        }

        teacherMap.entrySet().forEach(teacher -> {
            double total = teachings.stream()
                    .filter(s -> s.getTeacher().getId().compareTo(teacher.getKey()) == 0)
                    .mapToDouble(s -> s.getHours())
                    .sum();
            System.out.println(String.format("%s %.2f", teacher.getValue().getName(), total));
        });

    }
}
