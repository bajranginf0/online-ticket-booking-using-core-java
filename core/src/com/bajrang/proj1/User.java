package com.bajrang.proj1;

import java.util.List;

//User class: Represents a user trying to book tickets
public class User extends Thread {
 private String username;
 private String mobileNumber;
 private Train train;
 private int numPeople;
 private double ticketPrice;

 public User(String username, String mobileNumber, Train train, int numPeople, double ticketPrice) {
     this.username = username;
     this.mobileNumber = mobileNumber;
     this.train = train;
     this.numPeople = numPeople;
     this.ticketPrice = ticketPrice;
 }

 @Override
 public void run() {
	 
     synchronized (train) {
         int availableSeats = train.getAvailableSeats();
         if (availableSeats >= numPeople) {
             List<Ticket> bookedTickets = train.bookTickets(numPeople);
             double totalAmount = numPeople * ticketPrice;
             double discount = (numPeople >= 5) ? totalAmount * 0.10 : 0; // 10% discount for 5+ people
             totalAmount -= discount;

             System.out.println("Booking Successful!");
             System.out.println("Username: " + username);
             System.out.println("Mobile: " + mobileNumber);
             System.out.println("Train: " + train.getTrainName());
             System.out.println("Coach: " + train.getCoach());
             System.out.println("Booked Seats: " + bookedTickets.stream().map(Ticket::getSeatNumber).toList());
             System.out.println("Amount: rs " + totalAmount + " (Discount: rs " + discount + ")");
         } else {
             System.out.println("Booking Failed for " + username + ". Only " + availableSeats + " seats are available.");
         }
     }
 }
}
