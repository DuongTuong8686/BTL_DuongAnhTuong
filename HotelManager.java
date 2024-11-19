import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelManager {
    private List<Customer> customers;
    private List<Room> rooms;
    private List<Booking> bookings;

    public HotelManager() {
        customers = new ArrayList<>();
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // Thêm khách hàng mới
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Thêm phòng mới
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Đặt phòng
    public void bookRoom(String customerId, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        Customer customer = findCustomerById(customerId);
        Room room = findRoomByNumber(roomNumber);

        if (customer == null) {
            System.out.println("Đặt phòng thất bại. Không tìm thấy khách hàng với mã: " + customerId);
            return;
        }

        if (room == null) {
            System.out.println("Đặt phòng thất bại. Không tìm thấy phòng với số: " + roomNumber);
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Đặt phòng thất bại. Phòng số " + roomNumber + " đã được đặt.");
            return;
        }

        Booking booking = new Booking(customer, room, checkIn, checkOut);
        bookings.add(booking);
        room.setAvailable(false); // Phòng đã đặt không còn khả dụng
        System.out.println("Đặt phòng thành công: " + booking);
    }

    // Thanh toán tiền phòng
    public void checkout(int roomNumber) {
        Booking booking = findBookingByRoomNumber(roomNumber);

        if (booking == null) {
            System.out.println("Thanh toán thất bại. Không tìm thấy đặt phòng cho phòng số: " + roomNumber);
            return;
        }

        double totalPrice = booking.calculateTotalPrice();
        System.out.println("Thanh toán thành công. Tổng tiền: " + totalPrice);
        booking.getRoom().setAvailable(true); // Phòng khả dụng sau khi trả
        bookings.remove(booking);
    }

    // Hiển thị danh sách khách hàng
    public void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("Không có khách hàng nào.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    // Hiển thị danh sách phòng
    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("Không có phòng nào.");
        } else {
            for (Room room : rooms) {
                System.out.println(room);
            }
        }
    }

    // Hiển thị danh sách đặt phòng
    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Không có đặt phòng nào.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    // Tìm khách hàng theo ID
    private Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    // Tìm phòng theo số phòng
    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Tìm đặt phòng theo số phòng
    private Booking findBookingByRoomNumber(int roomNumber) {
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == roomNumber) {
                return booking;
            }
        }
        return null;
    }
}

