import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int choice;
        do {
            System.out.println("\nQuản lý khách sạn");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Thêm phòng");
            System.out.println("3. Đặt phòng");
            System.out.println("4. Thanh toán");
            System.out.println("5. Hiển thị thông tin hiện có");
            System.out.println("6. Thoát");
            System.out.print("Vui lòng chọn chức năng (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý dòng mới sau khi nhập số

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã khách hàng: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Nhập số điện thoại khách hàng: ");
                    String customerPhone = scanner.nextLine();
                    Customer customer = new Customer(customerId, customerName, customerPhone);
                    hotelManager.addCustomer(customer);
                    System.out.println("Thêm khách hàng thành công.");
                    System.out.println("Danh sách khách hàng hiện có:");
                    hotelManager.displayCustomers();
                    break;

                case 2:
                    System.out.print("Nhập số phòng: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Xử lý dòng mới
                    System.out.print("Nhập loại phòng: ");
                    String roomType = scanner.nextLine();
                    System.out.print("Nhập giá phòng mỗi đêm: ");
                    double price = scanner.nextDouble();
                    Room room = new Room(roomNumber, roomType, price);
                    hotelManager.addRoom(room);
                    System.out.println("Thêm phòng thành công.");
                    System.out.println("Danh sách phòng hiện có:");
                    hotelManager.displayRooms();
                    break;

                case 3:
                    System.out.print("Nhập mã khách hàng: ");
                    String bookingCustomerId = scanner.nextLine();
                    System.out.print("Nhập số phòng: ");
                    int bookingRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Xử lý dòng mới
                    System.out.print("Nhập ngày nhận phòng (dd/MM/yyyy): ");
                    String checkInDateStr = scanner.nextLine();
                    LocalDate checkInDate = LocalDate.parse(checkInDateStr, dateFormatter);
                    System.out.print("Nhập ngày trả phòng (dd/MM/yyyy): ");
                    String checkOutDateStr = scanner.nextLine();
                    LocalDate checkOutDate = LocalDate.parse(checkOutDateStr, dateFormatter);
                    hotelManager.bookRoom(bookingCustomerId, bookingRoomNumber, checkInDate, checkOutDate);
                    System.out.println("Danh sách đặt phòng hiện có:");
                    hotelManager.displayBookings();
                    break;

                case 4:
                    System.out.print("Nhập số phòng để thanh toán: ");
                    int checkoutRoomNumber = scanner.nextInt();
                    hotelManager.checkout(checkoutRoomNumber);
                    break;

                case 5:
                    System.out.println("Hiển thị tất cả thông tin:");
                    System.out.println("Danh sách khách hàng:");
                    hotelManager.displayCustomers();
                    System.out.println("\nDanh sách phòng:");
                    hotelManager.displayRooms();
                    System.out.println("\nDanh sách đặt phòng:");
                    hotelManager.displayBookings();
                    break;

                case 6:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

