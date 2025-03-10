package code_ptit.practice.shop;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Bill implements Comparable<Bill>{
    private Customer customer;
    private Product product;
    private int quantity;
    private LocalDate boughtDate;

    public Bill(Customer customer, Product product, int quantity, String boughtDate) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
       try {
           this.boughtDate = LocalDate.parse(boughtDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       } catch (Exception e) {

       }
    }

    public LocalDate expiredDate() {
        return boughtDate.plusMonths(product.getWarranty());
    }

    @Override
    public String toString() {
        return customer + " " + product.getId() + " " + (product.getSell() * quantity) + " " + (expiredDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }

    @Override
    public int compareTo(Bill o) {
        return expiredDate().compareTo(o.expiredDate());
    }
}
