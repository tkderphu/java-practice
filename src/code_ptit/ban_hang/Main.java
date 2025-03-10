package code_ptit.ban_hang;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner khInput = new Scanner(new File("TRUYVAN.in"));
        Scanner mhInput = new Scanner(new File("CODE.cpp"));
        Scanner hdInput = new Scanner(new File("SINHVIEN.in"));

        HashMap<String, Customer> customers = new HashMap<>();
        HashMap<String, Item> items = new HashMap<>();
        ArrayList<Bill> bills = new ArrayList<>();

        int numberOfCustomer = Integer.parseInt(khInput.nextLine());
        for(int i = 0; i < numberOfCustomer; i++) {
            Customer customer = new Customer(
                    i + 1,
                    khInput.nextLine(),
                    khInput.nextLine(),
                    khInput.nextLine(),
                    khInput.nextLine()
            );
            customers.put(customer.getId(), customer);
        }

        int numberOfItem = Integer.parseInt(mhInput.nextLine());
        for(int i = 0; i < numberOfItem; i++) {
            Item item = new Item(
                    i + 1,
                    mhInput.nextLine(),
                    mhInput.nextLine(),
                    Integer.parseInt(mhInput.nextLine()),
                    Integer.parseInt(mhInput.nextLine())
            );
            items.put(item.getId(), item);
        }

        int numberOfBill = Integer.parseInt(hdInput.nextLine());
        for(int i = 0; i < numberOfBill; i++) {
            String[] words = hdInput.nextLine().split("\\s+");
            bills.add(new Bill(
                    i + 1,
                    customers.get(words[0]),
                    items.get(words[1]),
                    Integer.parseInt(words[2])
            ));
        }

        bills.forEach(s -> {
            System.out.println(s);
        });

    }
}
