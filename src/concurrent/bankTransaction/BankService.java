package concurrent.bankTransaction;

import java.util.List;

public class BankService {
    private List<BankAccount> accounts = List.of(
            new BankAccount("phu", 50),
            new BankAccount("nam", 50)
    );

    public  BankAccount getAccount(String name) {
        return accounts.stream().filter(account -> account.name.equals(name))
                .findFirst().orElse(null);
    }
}
