package concurrent;

import asynchronize.testandset.MyRunnable;

public class e1 {
    static class MyThread implements Runnable {
        private String myName;

        public MyThread(String myName) {
            this.myName = myName;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("print my name: " + myName);
            System.out.println("End thread myname: " + myName);
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread("test"));
        Thread t2 = new Thread(new MyThread("test2"));
        t1.start();
        t2.start();

        System.out.println("fuck");
    }
}
