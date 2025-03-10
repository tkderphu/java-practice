package code_ptit.practice.shop;

public class Customer {
    private String id;
    private String fullName;
    private String address;

    public Customer(String id, String fullName, String address) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
    }

    @Override
    public String toString() {
        return id + " " + fullName + " " + address;
    }
}
