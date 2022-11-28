public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("Ulympian", 8, 12);
        //theatre.getseats();

        if (theatre.reserveSeat("H11")){
            System.out.println("please pay");
        } else{
            System.out.println("Seat taken");
        }
    }
}
