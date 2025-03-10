package code_ptit.practice.security;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        BinaryFile<String> stringBinaryFile = new BinaryFile<>("DATA.in");
//        List<String> str = List.of(
//                "Java Programming 5 has 371 pages.",
//                "More than 70 % …"
//        );
        TreeSet<Integer> res = new TreeSet<>();
        for(String x : stringBinaryFile.getList()) {
            String[] words = x.split("\\s+");
            for(String mInt : words) {
                try {
                    res.add(Integer.parseInt(mInt));
                } catch (Exception e) {

                }
            }
        }
        for(int x : res) System.out.println(x);
    }
}
