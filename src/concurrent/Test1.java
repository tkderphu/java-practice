package concurrent;

import java.util.concurrent.ThreadPoolExecutor;

public class Test1 {
    public static void main(String[] args) {
        Object b = new Object();
        Thread t = new Thread(() -> {
            try {
                synchronized (b) {
                    System.out.println("hello guys");
                    b.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ;
        });
        t.start();
    }
}
