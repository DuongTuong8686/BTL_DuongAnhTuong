
import java.time.LocalDate;

public class Booking {
    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public double calculateTotalPrice() {
        long days = checkInDate.until(checkOutDate).getDays();
        return days * room.getPricePerNight();
    }

    @Override
    public String toString() {
        return "Đặt phòng [Khách hàng: " + customer.getName() + ", Phòng: " + room.getRoomNumber() + ", Ngày nhận phòng: " + checkInDate + ", Ngày trả phòng: " + checkOutDate + "]";
    }
}

