package concurrent.lock;

import java.util.concurrent.locks.Lock;

public class Runnable1 implements Runnable{

    private Lock lock;
    private MyCount count;
    public Runnable1(Lock lock, MyCount myCount) {
        this.lock = lock;
        this.count = myCount;
    }

    @Override
    public void run() {
        this.lock.lock();
        this.count.count += 1;
        System.out.println("this count: " + this.count.count);
        this.lock.unlock();
    }


}
