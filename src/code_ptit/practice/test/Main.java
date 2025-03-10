package code_ptit.practice.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("HOIDONG.in"));
        Map<String, Subject> subjectMap = new HashMap<>();
        int num = Integer.parseInt(input.nextLine());
        for(int i = 0; i < num; i++) {
            String id = input.nextLine();
            String name = input.nextLine();
            String format = input.nextLine();
            subjectMap.put(id, new Subject(id, name, format));
        }
        input = new Scanner(new File("SINHVIEN.in"));
        Map<String, TestRoom> roomMap = new HashMap<>();
        num = Integer.parseInt(input.nextLine());
        for(int i = 0; i < num; i++) {
            String date = input.nextLine();
            String time = input.nextLine();
            String idRoom = input.nextLine();
            TestRoom testRoom = new TestRoom(i + 1, date + " " + time, idRoom);
            roomMap.put(testRoom.getId(), testRoom);
        }
        List<TestTime> testTimes = new ArrayList<>();
        input = new Scanner(new File("CODE.cpp"));
        num = Integer.parseInt(input.nextLine());
        for(int i = 0; i < num; i++) {
            String words[] = input.nextLine().split("\\s+");
            testTimes.add(new TestTime(
                    roomMap.get(words[0]),
                    subjectMap.get(words[1]),
                    (words[2]),
                    Integer.parseInt(words[3])
            ));
        }
        Collections.sort(testTimes);
        testTimes.forEach(s -> System.out.println(s));
    }
}
