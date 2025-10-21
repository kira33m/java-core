package lessons.lesson6;

import java.io.Serializable;

public class Seat implements Serializable {
    private final String seatNumber;
    private final String seatClass;
    private boolean booked;
    private String passengerName;

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.booked = false;
        this.passengerName = null;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
    public String getSeatClass() {
        return seatClass;
    }
    public boolean isBooked() {
        return booked;
    }
    public String getPassengerName() {
        return passengerName;
    }

    public void book(String name) throws SeatAlreadyBookedException {
        if (booked) {
            throw new SeatAlreadyBookedException("Место " + seatNumber + " уже забронировано!");
        }
        this.booked = true;
        this.passengerName = name;
    }
    public void cancel() throws BookingNotFoundException {
        if (!booked) {
            throw new BookingNotFoundException("Место " + seatNumber + " не было забронировано");
        }
        this.booked = false;
        this.passengerName = null;
    }
    @Override
    public String toString() {
        return String.format("Место %s (%s): %s%s",
            seatNumber,
            seatClass,
            booked ? "ЗАНЯТО" : "СВОБОДНО",
            booked ? " (" + passengerName + ")" : "");
    }
}