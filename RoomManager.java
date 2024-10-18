import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private List<Room> rooms;  // Danh sách các phòng

    // Constructor khởi tạo RoomManager với danh sách phòng trống
    public RoomManager() {
        rooms = new ArrayList<>();
    }

    // Phương thức thêm phòng mới vào danh sách
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Phương thức tìm phòng theo số phòng
    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;  // Trả về null nếu không tìm thấy phòng
    }

    // Phương thức xóa phòng khỏi danh sách
    public boolean removeRoom(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            rooms.remove(room);
            return true;
        }
        return false;
    }

    // Phương thức cập nhật trạng thái phòng
    public boolean updateRoomStatus(int roomNumber, String newStatus) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            room.setStatus(newStatus);
            return true;
        }
        return false;
    }

    // Phương thức hiển thị tất cả các phòng
    public void displayAllRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    // Phương thức kiểm tra xem phòng đã được đặt chưa
    public boolean isRoomBooked(int roomNumber) {
        Room room = findRoom(roomNumber);
        if (room != null) {
            return room.isBooked();
        }
        return false;
    }
}
