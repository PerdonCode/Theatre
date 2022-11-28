
import java.util.*;

public class Theatre {
    private final String theatreName;
    private final List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    // Binary search is the fastest way to find an item in a sorted List
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("there is no seat " + seatNumber);
            return false;
        }

    }

    // for testing
    public void getseats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private static class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            return false;
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " Canceled");
                return true;
            }
            return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}
