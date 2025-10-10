package lessons.lesson6;

import java.util.List;

public class AirplaneVisualizer {

    public static void display(List<Seat> seats) {
        System.out.println("\n=== ВИЗУАЛИЗАЦИЯ САМОЛЁТА ===");

        for (int row = 1; row <= 21; row++) {
            StringBuilder rowDisplay = new StringBuilder(String.format("%2d | ", row));

            if (row <= 5) {
                // Бизнес-класс: 2 места — проход — 2 места
                rowDisplay.append(drawSeat(seats, row, 'A'))
                    .append(drawSeat(seats, row, 'C'))
                    .append("   ") // проход
                    .append(drawSeat(seats, row, 'D'))
                    .append(drawSeat(seats, row, 'F'));
            } else {
                // Эконом-класс: 3 места — проход — 3 места
                rowDisplay.append(drawSeat(seats, row, 'A'))
                    .append(drawSeat(seats, row, 'B'))
                    .append(drawSeat(seats, row, 'C'))
                    .append("   ") // проход
                    .append(drawSeat(seats, row, 'D'))
                    .append(drawSeat(seats, row, 'E'))
                    .append(drawSeat(seats, row, 'F'));
            }

            System.out.println(rowDisplay);
        }

        System.out.println("==============================\n");
    }

    private static String drawSeat(List<Seat> seats, int row, char seatLetter) {
        String seatNum = row + String.valueOf(seatLetter);
        Seat s = findSeat(seats, seatNum);
        if (s == null) return "   ";
        return s.isBooked() ? "[X]" : "[ ]";
    }

    private static Seat findSeat(List<Seat> seats, String seatNumber) {
        for (Seat s : seats) {
            if (s.getSeatNumber().equalsIgnoreCase(seatNumber)) {
                return s;
            }
        }
        return null;
    }
}
