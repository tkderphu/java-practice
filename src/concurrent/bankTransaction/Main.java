package concurrent.bankTransaction;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var bankService = new BankService();
        BankAccount phu = bankService.getAccount("phu");
        System.out.println("=================Amount before transaction: " + phu.balance + " =====================");
        Thread thread = new Thread(() -> {
            phu.deposit(50);
        });
        Thread thread1 = new Thread(() -> {
            phu.deposit(50);
        });
        Thread thread2 = new Thread(() -> {
            phu.deposit(50);
        });
        Thread thread3 = new Thread(() -> {
            phu.withdraw(50);
        });
        Thread thread4 = new Thread(() -> {
            phu.withdraw(50);
        });

        //5 threads for deposit to account at the same time
        //if not using synchronized keyword
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        //wait for all thread completed
        Thread.sleep(2000);
        //expected: balance: 150 + 50 - 100 = 100
        System.out.println("After transaction amount are: " + phu.balance);
    }
}
