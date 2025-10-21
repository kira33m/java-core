package lessons.lesson6;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private List<Seat> seats;

    public Airplane() {
        this.seats = new ArrayList<>();
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
    public List<Seat> getSeats() {
        return seats;
    }

    private Seat getSeat(String seatNumber) throws SeatNotFoundException {
        for (Seat s : seats) {
            String currentSeatNumber = s.getSeatNumber();
            if (currentSeatNumber.equals(seatNumber)) {
                return s;
            }
        }
        throw new SeatNotFoundException("Место " + seatNumber + " не найдено!");
    }
    public void bookSeat(String seatNumber, String name)
        throws SeatNotFoundException, SeatAlreadyBookedException {
        Seat s = getSeat(seatNumber);
        s.book(name);
    }
    public void cancelBooking(String seatNumber)
        throws SeatNotFoundException, BookingNotFoundException {
        Seat s = getSeat(seatNumber);
        s.cancel();
    }
    public void showAllSeats() {
        for (Seat s : seats) {
            System.out.println(s);
        }
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