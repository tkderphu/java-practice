package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        MyCount myCount = new MyCount();
        Runnable1 runnable1 = new Runnable1(lock, myCount);
        Runnable1 runnable2 = new Runnable1(lock, myCount);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

    }
}
