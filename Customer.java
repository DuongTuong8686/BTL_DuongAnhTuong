
public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Customer(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters và Setters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Customer: " + name + ", Address: " + address + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
