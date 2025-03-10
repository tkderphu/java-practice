package code_ptit.practice.competition;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        Map<String, Institution> institutionMap = new HashMap<>();
        List<Team> teams = new ArrayList<>();
        int num = Integer.parseInt(sc.nextLine());
        for(int i =0; i < num; i++) {
            String w = sc.nextLine();
            int index = w.indexOf(" ");
            String code = w.substring(0, index);
            String name = w.substring(index + 1);
            institutionMap.put(code, new Institution(code, name));
        }
        sc = new Scanner(new File("HOIDONG.in"));
        num = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < num; i++) {
            String[] words = sc.nextLine().split("\\s+");
            for(int j = 0; j < Integer.parseInt(words[1]); j++) {
                teams.add(new Team(institutionMap.get(words[0]), sc.nextLine()));
            }
        }
        Collections.sort(teams);
        for(int i = 0; i < teams.size(); i++) {
            String id = String.format("team%02d", i + 1);
            System.out.println(id + " " + teams.get(i));
        }
    }
}
