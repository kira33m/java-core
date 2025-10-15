package lessons.lesson7;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Duration;

@Getter
public class Seat implements Serializable {

    private final String seatNumber;
    private final String seatClass;
    private SeatStatus status;
    private String passengerName;
    private LocalDateTime bookingTime;

    private static final long EXPIRATION_MINUTES = 24;

    public Seat(String seatNumber, String seatClass) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.status = SeatStatus.FREE;
    }

    public boolean isBooked() {
        return status == SeatStatus.BOOKED || status == SeatStatus.PAID;
    }

    public void book(String name) throws SeatAlreadyBookedException {
        if (isBooked()) {
            throw new SeatAlreadyBookedException("Место " + seatNumber + " уже забронировано или оплачено!");
        }
        this.status = SeatStatus.BOOKED;
        this.passengerName = name;
        this.bookingTime = LocalDateTime.now();
    }
    public void pay() throws BookingNotFoundException {
        if (status !=  SeatStatus.BOOKED) {
            throw new BookingNotFoundException("Место " + seatNumber + " нельзя оплатить — оно не забронировано!");
        }
        this.status = SeatStatus.PAID;
    }
    public void cancel() throws BookingNotFoundException {
        if (status == SeatStatus.FREE) {
            throw new BookingNotFoundException("Место " + seatNumber + " не было забронировано");
        }
        this.status = SeatStatus.FREE;
        this.passengerName = null;
        this.bookingTime = null;
    }
    public boolean isBookingExpired() {
        if (status == SeatStatus.BOOKED || bookingTime == null) return false;
        Duration diff = Duration.between(bookingTime, LocalDateTime.now());
        return diff.toMinutes() >= EXPIRATION_MINUTES;
    }
    @Override
    public String toString() {
       String info = String.format("Место %s (%s): %s", seatNumber, seatClass, status);
       if (isBooked()) info += " (" + passengerName + ")";
       if (bookingTime != null) info += " [" + bookingTime + "]";
       return info;
    }
}