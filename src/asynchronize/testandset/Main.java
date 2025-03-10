package asynchronize.testandset;

public class Main {
    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock(false);
        MyRunnable myRunnable = new MyRunnable(0, lock);
        for(int i = 1; i <= 10; i++) {
            Thread t = new Thread(myRunnable);
            t.start();
        }
        Thread.sleep(1000);
        System.out.println(myRunnable.getNum());
    }
    public static boolean testAndTest(Lock lock) {
        boolean rv = lock.isLock();
        lock.setLock(true);
        return rv;
    }
}
