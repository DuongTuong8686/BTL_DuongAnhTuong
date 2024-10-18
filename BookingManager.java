import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    // Thêm đặt phòng
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    // Hủy đặt phòng
    public void cancelBooking(Booking booking) {
        booking.cancelBooking();
        bookings.remove(booking);
    }

    // Hiển thị danh sách đặt phòng
    public void displayBookings() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}

