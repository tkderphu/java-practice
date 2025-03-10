package code_ptit.ban_hang;

public class Customer {

    private String id;
    private String name;
    private String gender;
    private String dateOfBirth;
    private String address;

    public Customer(int id, String name, String gender, String dateOfBirth, String address) {
        this.id = String.format("KH%03d", id);
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
