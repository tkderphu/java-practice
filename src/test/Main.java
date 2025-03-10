package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Long sum = 0l;
        Scanner scanner = new Scanner(new File("DATA.in"));
        while(scanner.hasNext()) {
            String str = scanner.next();
            try {
                Integer.parseInt(str);
            } catch (Exception e) {
                try {
                    sum += Long.parseLong(str);
                } catch (Exception ex) {

                }
            }
        }
        System.out.println(sum);
    }
}
