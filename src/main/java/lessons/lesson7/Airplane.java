package lessons.lesson7;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Airplane {
    private List<Seat> seats;
    private LocalDate flightDate;

    public Airplane() {
        this.seats = new ArrayList<>();
        this.flightDate = LocalDate.now().plusDays(1);
        initializeSeats();
    }

    private void initializeSeats() {
        for (int row = 1; row <= 5; row++) {
            for (char seat : new char[]{'A', 'C', 'D', 'F'}) {
                seats.add(new Seat(row + String.valueOf(seat), "Business"));
            }
        }
        for (int row = 6; row <= 21; row++) {
            for (char seat = 'A'; seat <= 'F'; seat++) {
                seats.add(new Seat(row + String.valueOf(seat), "Economy"));
            }
        }
    }


    public Seat getSeat(String seatNumber) throws SeatNotFoundException {
        return seats.stream()
            .filter(s -> s.getSeatNumber().equalsIgnoreCase(seatNumber))
            .findFirst()
            .orElseThrow(() -> new SeatNotFoundException("Место " + seatNumber + " не найдено!"));
    }

    public void bookSeat(String seatNumber, String name)
            throws SeatNotFoundException, SeatAlreadyBookedException {
        getSeat(seatNumber).book(name);
    }

    public void cancelBooking(String seatNumber)
            throws SeatNotFoundException, BookingNotFoundException {
        getSeat(seatNumber).cancel();
    }

    public void checkExpiredBookings() {
        for (Seat s : seats) {
            if (s.isBookingExpired()) {
                System.out.println("⏰ Истекла бронь на место " + s.getSeatNumber() + ", освобождено.");
                try {
                    s.cancel();
                } catch (BookingNotFoundException ignored) {}
            }
        }
    }

    public void showAllSeats() {
        seats.forEach(System.out::println);
    }

    public void showBookingInfo(String seatNumber) {
        try {
            Seat s = getSeat(seatNumber);
            if (s.isBooked()) {
                System.out.println("Место " + s.getSeatNumber() +
                        " забронировано пассажиром " + s.getPassengerName() +
                        " (" + s.getSeatClass() + ")");
            } else {
                System.out.println("Место " + s.getSeatNumber() + " свободно (" + s.getSeatClass() + ")");
            }
        }  catch (SeatNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}