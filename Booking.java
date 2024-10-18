import java.util.Date;

public class Booking {
    private Room room;
    private Customer customer;
    private Date checkInDate;
    private Date checkOutDate;

    public Booking(Room room, Customer customer, Date checkInDate, Date checkOutDate) {
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        room.setStatus("Đã có"); // Đặt trạng thái phòng là Đã có khách
    }

    // Getters
    public Room getRoom() { return room; }
    public Customer getCustomer() { return customer; }
    public Date getCheckInDate() { return checkInDate; }
    public Date getCheckOutDate() { return checkOutDate; }

    @Override
    public String toString() {
        return "Booking: Room " + room.getRoomNumber() + ", Customer: " + customer.getName() +
                ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate;
    }

    public void cancelBooking() {
        room.setStatus("Trống"); // Đặt lại trạng thái phòng là trống
    }
}
