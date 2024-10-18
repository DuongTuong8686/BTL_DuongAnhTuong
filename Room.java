public class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private String status;  // Trạng thái phòng: Available, Occupied, Maintenance

    // Constructor khởi tạo đối tượng Room
    public Room(int roomNumber, String roomType, double price, String status) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
    }

    // Các phương thức getter và setter cho các thuộc tính
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Phương thức kiểm tra phòng có được đặt hay không
    public boolean isBooked() {
        return "Occupied".equalsIgnoreCase(status); // Trả về true nếu phòng đang được đặt
    }

    // Phương thức toString để in ra thông tin của phòng
    @Override
    public String toString() {
        return "Room [Room Number=" + roomNumber + ", Room Type=" + roomType +
                ", Price=" + price + ", Status=" + status + "]";
    }
}
