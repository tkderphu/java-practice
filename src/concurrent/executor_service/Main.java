package concurrent.executor_service;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(runnable("f1"));
//        future.cancel(false);
        String s = future.get();
        System.out.println("Task was canceled: " + future.isCancelled());
        try {

        } catch (Exception e) {

        }
        boolean b = executorService.awaitTermination(2000, TimeUnit.SECONDS);
        System.out.println(b);
        System.out.println("helo");
    }
    public static Callable runnable(String msg) {
        return () -> {
            String currentThread = Thread.currentThread().getName() + ": " + msg;
            try {
                System.out.println("start: " + currentThread);
                Thread.sleep(4000);
                System.out.println("completed: " + currentThread);
                return currentThread;
            } finally {
            }
        };
    }
}
