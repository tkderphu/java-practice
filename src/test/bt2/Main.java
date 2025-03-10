package test.bt2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Worker> workers = new ArrayList<>();
        int num = Integer.parseInt(input.nextLine());
        while(num -- > 0) {
            String id = input.nextLine();
            String name = input.nextLine();
            String in = input.nextLine();
            String out = input.nextLine();
            workers.add(new Worker(id, name, in, out));
        }
        Collections.sort(workers);
        for(Worker w : workers) {
            System.out.println(w);
        }
    }
}
