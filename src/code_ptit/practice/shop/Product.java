package code_ptit.practice.shop;

import java.util.Date;

public class Product {
    private String id;
    private String name;
    private int sell;
    private int warranty;

    public Product(String id, String name, int sell, int warranty) {
        this.id = id;
        this.name = name;
        this.sell = sell;
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public int getSell() {
        return sell;
    }

    public String getId() {
        return id;
    }
}
