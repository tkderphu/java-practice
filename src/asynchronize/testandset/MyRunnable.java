package asynchronize.testandset;

public class MyRunnable implements Runnable{
    private  int num;
    private Lock lock;
    public MyRunnable(int num, Lock lock) {
        this.num = num;
        this.lock = lock;
    }
    @Override
    public void run() {
       while(testAndSet(lock));

       num += 5;
       this.lock.setLock(false);
    }
    public int getNum() {
        return num;
    }

    private boolean testAndSet(Lock lock) {
        boolean x =lock.isLock();
        lock.setLock(true);
        return x;
    }
}
