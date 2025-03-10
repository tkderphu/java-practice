//package concurrent.lock;
//
//import java.util.concurrent.locks.Lock;
//
//public class Runnable2 implements Runnable{
//
//    private Lock lock;
//    private
//
//
//    public Runnable2(Lock lock, MyCount myCount) {
//        this.lock = lock;
//        this.count = myCount;
//    }
//
//    @Override
//    public void run() {
//        this.lock.lock();
//        this.count.count += 1;
//        System.out.println("this count: " + this.count.count);
//        this.lock.unlock();
//    }
//
//
//}
