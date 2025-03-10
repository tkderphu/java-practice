package code_ptit.practice.shop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("CODE.cpp"));
        Map<String, Product> productMap =  new HashMap<>();
        Map<String, Customer> customerMap = new HashMap<>();
        List<Bill> bills = new ArrayList<>();
        int numberOfProduct = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < numberOfProduct; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int sell = Integer.parseInt(sc.nextLine());
            int warranty = Integer.parseInt(sc.nextLine());
            if(!productMap.containsKey(id)) {
                productMap.put(id, new Product(id, name, sell, warranty));
            }
        }
        int numOfCustomer = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < numOfCustomer; i++) {
            String id = String.format("KH%02d", i + 1);
            String fullName = sc.nextLine();
            String address = sc.nextLine();
            String productId = sc.nextLine();
            int quantity = Integer.parseInt(sc.nextLine());
            String boughtDate = sc.nextLine();
            customerMap.put(id, new Customer(id, fullName, address));
            Bill bill = new Bill(
                    customerMap.get(id),
                    productMap.get(productId),
                    quantity,
                    boughtDate
            );
            bills.add(bill);
        }
        Collections.sort(bills);
        bills.forEach(s -> System.out.println(s));
    }
}
