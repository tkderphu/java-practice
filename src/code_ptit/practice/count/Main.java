package code_ptit.practice.count;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("CODE.cpp"));
        int cnt = 0;
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.contains("main()")) continue;
            if(line.contains("int")) {
                if(line.contains("[")) {
                    
                }
                else {
                    if(line.contains(",")) {
                        int comma = 0;
                        for(int i = 0; i < line.length(); i++) {
                            if(line.charAt(i) == ',') comma ++;
                        }
                        cnt += comma + 1;
                    } else {
                        cnt ++;
                    }
                }
            }
        }
        System.out.println(cnt * 4);
    }
}
