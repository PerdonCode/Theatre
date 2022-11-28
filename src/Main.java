import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        if (theatre.reserveSeat("A02")) {
            System.out.println("pay for seat");
        } else {
            System.out.println("Already reserved");
        }

        // sort on price
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getseats());
        priceSeats.add(theatre.new Seat("BOO", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
    }
}
