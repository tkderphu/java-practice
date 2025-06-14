package concurrent.bankTransaction;

public class BankAccount {
     String name;
     int balance;

    public BankAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public  void deposit(int amount) {
        this.balance += amount;
    }

    public  void withdraw(int amount) {
        this.balance -= amount;
    }
}
