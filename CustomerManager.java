import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    // Thêm khách hàng mới
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Tìm khách hàng theo tên hoặc số điện thoại
    public Customer findCustomer(String searchKey) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(searchKey) || customer.getPhoneNumber().equals(searchKey)) {
                return customer;
            }
        }
        return null;
    }

    // Xóa khách hàng
    public void removeCustomer(String searchKey) {
        Customer customer = findCustomer(searchKey);
        if (customer != null) {
            customers.remove(customer);
        }
    }

    // Hiển thị danh sách khách hàng
    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}

