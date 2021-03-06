/* Seat.java
 * EE422C Project 6 submission by
 * Replace <...> with your actual data.
 * Brian Wilmarth
 * bw24274
 * 15455
 * Spring 2018
 */
package assignment6;

public class Seat {
    private String rowLetter;
    private int seatNumber;

    /**
     * Constructs a seat object
     * @param rowLetter
     * @param seatNumber
     */
    public Seat(String rowLetter, int seatNumber){
        this.rowLetter = rowLetter;
        this.seatNumber = seatNumber;
    }

    /**
     * Builds a string for a seat object
     * @return String representation of a seat object
     */
    public String toString() {
        StringBuilder seat = new StringBuilder();
        seat.append(rowLetter);
        seat.append(seatNumber);
        return seat.toString();
    }

}