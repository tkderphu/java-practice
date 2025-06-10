package concurrent;

public class e3_joi {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
           for(int i = 1; i <= 5; i++) {
               System.out.println("value: " + i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("after complete print");
    }
}
