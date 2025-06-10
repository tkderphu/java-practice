package concurrent;

public class count_number {
    static class CountOddRunnable implements Runnable {
        int count = 0;
        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                if(i % 2 != 0) {
                    count ++;
                    System.out.println("odd from " + Thread.currentThread().getName() + ": " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            System.out.println("result from " + Thread.currentThread().getName() + ": " + count);
        }
    }

    static class CountEvenRunnable implements Runnable {
        int count = 0;
        @Override
        public void run() {
            for(int i = 0; i < 10; i++) {
                if(i % 2 == 0) {
                    count ++;
                    System.out.println("even from " + Thread.currentThread().getName() + ": " + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            System.out.println("result from " + Thread.currentThread().getName() + ": " + count);

        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new CountEvenRunnable());
        Thread t2 = new Thread(new CountOddRunnable());

        t1.start();
        t2.start();
    }
}
