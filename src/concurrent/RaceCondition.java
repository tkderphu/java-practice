package concurrent;

public class RaceCondition {
    public volatile int counter;

//    public  void increment() {
//        counter ++;
//    }
    public static void main(String[] args) throws InterruptedException {
        RaceCondition condition = new RaceCondition();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i <100_000; i++) {
                condition.counter ++;
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i <100_000; i++) {
                condition.counter ++;
            }
        });
        t1.start();
        t2.start();

//        t1.join();
//        t2.join();
        Thread.sleep(5000);
        System.out.println("Result: "+  condition.counter);
    }
}
