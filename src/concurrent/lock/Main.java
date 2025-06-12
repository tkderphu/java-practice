package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       ExecutorService executorService = new ExecutorService(2, 5);

       executorService.submit(() -> {
           System.out.println("Load data to server need 10s");
           try {
               Thread.sleep(10000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("Load data to server need 10s successfully");

       });


        executorService.submit(() -> {
            System.out.println("Client sent request for search user with name: test, need 5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Client sent request for search user with name: test, need 5s success");

        });


        executorService.submit(() -> {
            System.out.println("test queue 3 5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test queue 3 5s ok");

        });


        executorService.submit(() -> {
            System.out.println("test queue 4 5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test queue 4 5s ok");

        });

        executorService.submit(() -> {
            System.out.println("test queue 5 5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("test queue 5 5s ok");

        });

    }
}
