package test.bt4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner bt = new Scanner(new File("BAITAP.in"));
        Scanner bc = new Scanner(new File("BAOCAO.in"));

        Map<String, Student> studentMap = new HashMap<>();
        while(bt.hasNextLine()) {
            String id = bt.nextLine();
            String name = bt.nextLine();
            String topic = bt.nextLine();

            studentMap.put(id, new Student(id, name, topic));
        }
        List<Report> reports = new ArrayList<>();
        while(bc.hasNextLine()) {
            String studentId = bc.nextLine();
            String time = bc.nextLine();
            reports.add(new Report(time,studentMap.get(studentId)));
        }

        List<Report> reportMorning = reports.stream().filter(s -> s.isMorning()).collect(Collectors.toList());
        List<Report> reportEvening = reports.stream().filter(s -> !s.isMorning()).collect(Collectors.toList());

            System.out.println("DANH SACH SINH VIEN BAO CAO CA SANG: " + reportMorning.size());
            for(Report r : reportMorning) {
                System.out.println(r);
            }

            System.out.println("DANH SACH SINH VIEN BAO CAO CA CHIEU: " + reportEvening.size());
            for(Report r : reportEvening) {
                System.out.println(r);
            }

    }
}
