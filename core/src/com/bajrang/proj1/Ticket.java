package com.bajrang.proj1;

//Ticket class: Represents a ticket
public class Ticket {
 private int seatNumber;
 private boolean isBooked;

 public Ticket(int seatNumber) {
     this.seatNumber = seatNumber;
     this.isBooked = false;
 }

 public int getSeatNumber() {
     return seatNumber;
 }

 public synchronized boolean bookTicket() {
     if (!isBooked) {
         isBooked = true;
         return true;
     }
     return false;
 }

 public boolean isBooked() {
     return isBooked;
 }
}
