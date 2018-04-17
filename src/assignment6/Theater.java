package assignment6;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private int N = 10; // number of rows
    private int M = 5; // number of seats per row
    private String show = "Incredibles 2";
    private List<Ticket> transactionLog = new ArrayList<>();
    private List<Seat> seats = new ArrayList<>();
    private boolean soldOut = false;

    /**
     * Constructs a theater object that contains a list of available seats
     * given dimensions N, the number of rows, and M, the number of seats per row.
     */
    public Theater() {
        ArrayList<String> rows = new ArrayList<>();
        int value;
        int x;
        for(int i = 0; i < N; i++){
            StringBuilder strBld = new StringBuilder();
            x = i;
            while(x/26 > 0){
                value = x % 26;
                x = (int) Math.floor(x/26) - 1;
                strBld.insert(0, Character.toString((char) (value + 65)));
            }
            strBld.insert(0, Character.toString((char) (x + 65)));
            rows.add(strBld.toString());
        }

        for(int n = 0; n < N; n++){
            for(int m = 1; m <= M; m++){
                seats.add(new Seat(rows.get(n), m));
            }
        }
    }

    /**
     * Sold out flag
     * @return Boolean value of soldOut
     */
    public synchronized boolean getSoldOut(){
        return soldOut;
    }

    /**
     * Sold out flag setter
     * @param soldOut desired value of soldOUt
     */
    public synchronized void setSoldOut(boolean soldOut){
        this.soldOut = soldOut;
    }

    /**
     * Returns the best available seat
     * @return Seat
     */
    public synchronized Seat bestAvailableSeat() {
        Seat best = null;
        if(seats.size() > 0) {
            best = seats.remove(0);
        }
        return best;
    }

    /**
     * Prints a ticket
     * @param bxID String - Box Office ID
     * @param seat Seat - seat
     * @param client int - Client ID
     * @return Ticket object
     */
    public synchronized Ticket printTicket(String bxID, Seat seat, int client) {
        Ticket ticket = new Ticket(this.show, bxID, seat, client);
        transactionLog.add(ticket);
        System.out.println(ticket.toString());
        return ticket;
    }

    /**
     * List of all transactions in order of tickets sold
     * @return List of Tickets
     */
    public List<Ticket> getTransactionLog() {
        return transactionLog;
    }
}
