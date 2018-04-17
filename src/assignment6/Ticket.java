package assignment6;

public class Ticket {
    private String show;
    private String bxID;
    private Seat seat;
    private Integer client;

    /**
     * Constructs a Ticket object
     * @param show String - Movie showing
     * @param bxID String - Box Office identifier
     * @param seat Seat - seat
     * @param client Integer - Client number
     */
    public Ticket (String show, String bxID, Seat seat, Integer client) {
        this.show = show;
        this.bxID = bxID;
        this.seat = seat;
        this.client = client;
    }

    /**
     * Returns a String representation of a ticket
     * @return String representation of the ticket
     */
    public String toString() {
        StringBuilder ticket = new StringBuilder();
        StringBuilder line = new StringBuilder();
        ticket.append("-------------------------------\n");

        line.append("| Show: ");
        line.append(show);
        for(int i = 0; i < 22-show.length(); i++) {
            line.append(" ");
        }
        line.append("|\n");
        ticket.append(line.toString());
        line.setLength(0);

        line.append("| Box Office ID: ");
        line.append(bxID);
        for(int i = 0; i < 13-bxID.length(); i++) {
            line.append(" ");
        }
        line.append("|\n");
        ticket.append(line.toString());
        line.setLength(0);

        line.append("| Seat: ");
        line.append(seat.toString());
        for(int i = 0; i < 22-seat.toString().length(); i++) {
            line.append(" ");
        }
        line.append("|\n");
        ticket.append(line.toString());
        line.setLength(0);

        line.append("| Client: ");
        line.append(client.toString());
        for(int i = 0; i < 20-client.toString().length(); i++) {
            line.append(" ");
        }
        line.append("|\n");
        ticket.append(line.toString());
        line.setLength(0);

        ticket.append("-------------------------------\n");
        return ticket.toString();
    }
}