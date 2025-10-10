package lessons.lesson6;

import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    private final Airplane airplane;
    public Scanner scanner = new Scanner(System.in);

    public BookingSystem() {
        List<Seat> loadedSeats = FileManager.load();
        airplane = new Airplane();
        if (loadedSeats != null) {
            airplane.getSeats().clear();
            airplane.getSeats().addAll(loadedSeats);
            System.out.println("✅ Данные успешно загружены из файла");
        }  else {
            System.out.println("Создан новый самолёт с пустыми местами.");
        }
    }
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showAllSeats();
                case "2" -> bookSeat();
                case "3" -> cancelBooking();
                case "4" -> showBookingInfo();
                case "5" -> visualizeAirplane();
                case "6" -> {
                    saveAndExit();
                    running = false;
                }
                default -> System.out.println("❌ Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n==== МЕНЮ БРОНИРОВАНИЯ АВИАБИЛЕТОВ ====");
        System.out.println("1. Показать все места");
        System.out.println("2. Забронировать место");
        System.out.println("3. Снять бронь");
        System.out.println("4. Информация о месте");
        System.out.println("5. Визуализировать самолёт");
        System.out.println("6. Выход (сохранение)");
        System.out.println("=======================================");
    }

    private void showAllSeats() {
        System.out.println("\n--- СПИСОК МЕСТ ---");
        airplane.showAllSeats();
    }

    private void bookSeat() {
        try {
            System.out.print("Введите номер места (например, 5A): ");
            String seatNumber = scanner.nextLine();
            System.out.print("Введите имя пассажира: ");
            String name = scanner.nextLine();
            airplane.bookSeat(seatNumber, name);
            System.out.println("✅ Место " + seatNumber + " успешно забронировано на имя " + name);
        } catch (SeatNotFoundException | SeatAlreadyBookedException e) {
            System.out.println("⚠ Ошибка: " + e.getMessage());
        }
    }

    private void cancelBooking() {
        try {
            System.out.print("Введите номер места для отмены брони: ");
            String seatNumber = scanner.nextLine();
            airplane.cancelBooking(seatNumber);
            System.out.println("✅ Бронь с места " + seatNumber + " успешно снята.");
        } catch (SeatNotFoundException | BookingNotFoundException e) {
            System.out.println("⚠ Ошибка: " + e.getMessage());
        }
    }

    private void showBookingInfo() {
        System.out.print("Введите номер места: ");
        String seatNumber = scanner.nextLine();
        airplane.showBookingInfo(seatNumber);
    }

    private void visualizeAirplane() {
        AirplaneVisualizer.display(airplane.getSeats());
    }

    private void saveAndExit() {
        FileManager.save(airplane.getSeats());
        System.out.println("💾 Все данные сохранены. До свидания!");
    }

    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        system.run();
    }
}
