package code_ptit.practice.luan_an;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Student> studentMap = new HashMap<>();
        Map<String, Topic> topicMap = new HashMap<>();
        Map<String, List<Committee>> committeeMap = new TreeMap<>();
        Scanner input = new Scanner(new File("SINHVIEN.in"));
        int numb = Integer.parseInt(input.nextLine());
        for(int i = 0; i < numb; i++) {
            String id = input.nextLine();
            String name = input.nextLine();
            String phone = input.nextLine();
            String email = input.nextLine();
            studentMap.put(id, new Student(id, name, phone, email));
        }
        input = new Scanner(new File("CODE.cpp"));
        numb = Integer.parseInt(input.nextLine());
        for(int i = 0; i < numb; i++) {
            String teacher = input.nextLine();
            String name = input.nextLine();
            Topic topic = new Topic(i + 1, name, teacher);
            topicMap.put(topic.getId(), topic);
        }
        input = new Scanner(new File("HOIDONG.in"));
        numb = Integer.parseInt(input.nextLine());
        for(int i = 0; i < numb; i++) {
            String words[] = input.nextLine().split("\\s+");
            if(!committeeMap.containsKey(words[2])) {
                List<Committee> committees = new ArrayList<>();
                committees.add(new Committee(topicMap.get(words[1]), studentMap.get(words[0])));
                committeeMap.put(words[2], committees);
            } else {
                committeeMap.get(words[2]).add( new Committee(topicMap.get(words[1]), studentMap.get(words[0])));
            }
        }
        for(Map.Entry<String, List<Committee>> entry : committeeMap.entrySet()) {
            System.out.println(String.format("DANH SACH %s:", Committee.ID.valueOf(entry.getKey()).getValue()));
            Collections.sort(entry.getValue());
            for(Committee x : entry.getValue()) {
                System.out.println(x);
            }
        }

    }
}
