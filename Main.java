import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        RoomManager roomManager = new RoomManager();
        CustomerManager customerManager = new CustomerManager();
        BookingManager bookingManager = new BookingManager();

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Quản lý phòng");
            System.out.println("2. Quản lý khách hàng");
            System.out.println("3. Quản lý đặt phòng");
            System.out.println("4. Thoát");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
                scanner.nextLine(); // Xóa dòng để tránh vòng lặp vô tận
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("1. Thêm phòng");
                    System.out.println("2. Hiển thị phòng");
                    int roomChoice = scanner.nextInt();
                    if (roomChoice == 1) {
                        System.out.println("Nhập số phòng: ");
                        int roomNumber = scanner.nextInt();
                        System.out.println("Nhập loại phòng: ");
                        String roomType = scanner.next();
                        System.out.println("Nhập giá phòng: ");
                        double price = scanner.nextDouble();
                        roomManager.addRoom(new Room(roomNumber, roomType, price, "Available"));
                    } else if (roomChoice == 2) {
                        roomManager.displayAllRooms(); // Đảm bảo gọi phương thức đúng
                    }
                    break;

                case 2:
                    System.out.println("1. Thêm khách hàng");
                    System.out.println("2. Hiển thị khách hàng");
                    int customerChoice = scanner.nextInt();
                    if (customerChoice == 1) {
                        System.out.println("Nhập tên khách hàng: ");
                        scanner.nextLine(); // Xóa dòng để đọc tên khách hàng
                        String name = scanner.nextLine();
                        System.out.println("Nhập địa chỉ: ");
                        String address = scanner.nextLine();
                        System.out.println("Nhập số điện thoại: ");
                        String phone = scanner.nextLine();
                        System.out.println("Nhập email: ");
                        String email = scanner.nextLine();
                        customerManager.addCustomer(new Customer(name, address, phone, email));
                    } else if (customerChoice == 2) {
                        customerManager.displayCustomers();
                    }
                    break;

                case 3:
                    System.out.println("1. Đặt phòng");
                    System.out.println("2. Hiển thị đặt phòng");
                    int bookingChoice = scanner.nextInt();
                    if (bookingChoice == 1) {
                        System.out.println("Nhập số phòng: ");
                        int roomNumber = scanner.nextInt();
                        Room room = roomManager.findRoom(roomNumber);
                        if (room == null || room.isBooked()) {
                            System.out.println("Phòng không tồn tại hoặc đã được đặt.");
                        } else {
                            System.out.println("Nhập tên khách hàng: ");
                            scanner.nextLine(); // Xóa dòng để đọc tên khách hàng
                            String customerName = scanner.nextLine();
                            Customer customer = customerManager.findCustomer(customerName);
                            if (customer == null) {
                                System.out.println("Khách hàng không tồn tại.");
                            } else {
                                System.out.println("Nhập ngày check-in (dd/MM/yyyy): ");
                                String checkIn = scanner.next();
                                System.out.println("Nhập ngày check-out (dd/MM/yyyy): ");
                                String checkOut = scanner.next();
                                try {
                                    Date checkInDate = sdf.parse(checkIn);
                                    Date checkOutDate = sdf.parse(checkOut);
                                    bookingManager.addBooking(new Booking(room, customer, checkInDate, checkOutDate));
                                } catch (Exception e) {
                                    System.out.println("Định dạng ngày không đúng.");
                                }
                            }
                        }
                    } else if (bookingChoice == 2) {
                        bookingManager.displayBookings();
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}

