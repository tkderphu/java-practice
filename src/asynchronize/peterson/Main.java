package asynchronize.peterson;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        while(true) {
            Maintain maintain = new Maintain();
            Number number = new Number(0);
            AtomicInteger numb = new AtomicInteger();
            Thread thread0 = new Thread(() -> {
                int m = 0;
//                do {
               maintain.setTurn(1);
               maintain.setFlag(0, true);
               while(maintain.getTurn() == 1 && maintain.getFlag()[1]);

               numb.addAndGet(1);
                    m ++;
               maintain.setFlag(0, false);
//               break;
//                } while (m <= 4);
            });

            Thread thread1 = new Thread(() -> {
                int i = 0;
//                do {
                maintain.setTurn(0);
                maintain.setFlag(1, true);
                while(maintain.getTurn() == 0 && maintain.getFlag()[0]);

                numb.addAndGet(-10);
                maintain.setFlag(1, false);
//                break;
                    i ++;
//                } while (i <= 4);
            });

            thread0.start();
            thread1.start();
//            thread1.join();
            System.out.println("Dang tinh toan: ");
//            Thread.sleep(1000);
            System.out.println("Ket qua cuoi cung: " + numb.get());
        }
    }


}
