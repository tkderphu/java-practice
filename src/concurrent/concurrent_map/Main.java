package concurrent.concurrent_map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> set1 =new HashSet<>( Set.of("5", "12", "7"));
        Set<String> set2 = new HashSet<>(Set.of("12"));

        System.out.println(set1.addAll(set2));
    }
}
