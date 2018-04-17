package assignment6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BookingClient {

    public static void main(String args[]) {
        BookingClient bc = new BookingClient();
        bc.simulate();
    }

    /**
     * Runs simulation of theater ticket sales
     * @return Returns the list of threads used
     */
    public static List<Thread> simulate() {
        int numBoxOffices = 3;
        int numPatrons = 1000;

        ArrayList<ArrayList<Integer>> clientLists = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        Theater theater = new Theater();

        // Create client lists
        for(int i = 0; i < numBoxOffices; i++){
            clientLists.add(new ArrayList<Integer>());
        }

        // Populate client lists with patrons
        int i = 0;
        while(i < numPatrons){
            for(int j = 0; j < numBoxOffices; j++){
                clientLists.get(j).add(new Integer(i));
                i++;
            }
        }
        // Create threads
        for(int j = 0; j < numBoxOffices; j++) {
            threadList.add(new Thread(new BoxOffice(j + 1, clientLists.get(j), theater)));
        }
        // Start threads
        for(Thread thread : threadList) {
            thread.start();
        }
        // Join threads
        try{
            for(Thread thread : threadList) {
                thread.join();
            }
        }
        catch(InterruptedException e){
            System.out.println("Couldn't join");
        }


        return threadList;
    }

    /**
     * BoxOffice class gathers data relevant to each box office
     */
    public static class BoxOffice implements Runnable{

        private String bxID;
        private List<Integer> clientList = new ArrayList<>();
        private Theater theater;

        /**
         * Create a BoxOffice
         * @param idNum int - ID Number
         * @param clientList ArrayList<Integer> - list of client IDs
         * @param theater - theater object that this boxOffice is selling tickets for
         */
        public BoxOffice(int idNum, List<Integer> clientList, Theater theater){
            bxID = "BX" + idNum;
            this.clientList = clientList;
            this.theater = theater;
        }

        /**
         * Portion of code that can be run in an individual thread
         */
        public void run() {
            for (Integer client : clientList) {
                if (theater.getSoldOut() != true) {
                    Seat seat = theater.bestAvailableSeat();
                    if (seat != null) {
                        theater.printTicket(bxID, seat, client);
                        try {
                            Thread.currentThread().sleep(50);
                        } catch (InterruptedException e) {
                            System.out.println("interrupted");
                        }
                    } else {
                        System.out.println("Sorry, we are sold out!");
                        theater.setSoldOut(true);
                    }
                }
            }
        }
    }
}
