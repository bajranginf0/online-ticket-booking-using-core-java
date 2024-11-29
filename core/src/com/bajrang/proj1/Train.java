package com.bajrang.proj1;

import java.util.ArrayList;
import java.util.List;

// Train class: Represents the train with ticket availability
public class Train {
    private String trainName;
    private String coach;
    private List<Ticket> tickets;

    public Train(String trainName, String coach, int totalSeats) {
        this.trainName = trainName;
        this.coach = coach;
        this.tickets = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            tickets.add(new Ticket(i));
        }
    }

    public String getTrainName() {
        return trainName;
    }

    public String getCoach() {
        return coach;
    }

    public synchronized List<Ticket> bookTickets(int numSeats) {
        List<Ticket> bookedTickets = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (!ticket.isBooked() && numSeats > 0) {
                if (ticket.bookTicket()) {
                    bookedTickets.add(ticket);
                    numSeats--;
                }
            }
        }
        return bookedTickets;
    }

    public int getAvailableSeats() {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (!ticket.isBooked()) {
                count++;
            }
        }
        return count;
    }
}