package code_ptit.ban_hang;

public class Bill {
    private String id;
    private Customer customer;
    private Item item;
    private int quantity;

    public Bill(int id, Customer customer, Item item,  int quantity) {
        this.id = String.format("HD%03d", id);
        this.item = item;
        this.customer = customer;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d %d %d %d",
                id, customer.getName(), customer.getAddress(),
                item.getName(), item.getUnit(), item.getBuy(),
                item.getSell(), quantity, (item.getSell()) * quantity);
    }
}
