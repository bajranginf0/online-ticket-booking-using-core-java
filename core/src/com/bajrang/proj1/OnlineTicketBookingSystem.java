package com.bajrang.proj1;

import java.util.Scanner;

// Main class: Simulates ticket booking system
public class OnlineTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Train details
        Train train = new Train("Express Train", "AC Coach", 10);
        double ticketPrice = 100.0;

        // User 1 details
        System.out.println("Enter details for User 1:");
        System.out.print("Username: ");
        String user1Name = scanner.nextLine();
        System.out.print("Mobile Number: ");
        String user1Mobile = scanner.nextLine();
        System.out.print("Number of People: ");
        int user1People = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // User 2 details
        System.out.println("\nEnter details for User 2:");
        System.out.print("Username: ");
        String user2Name = scanner.nextLine();
        System.out.print("Mobile Number: ");
        String user2Mobile = scanner.nextLine();
        System.out.print("Number of People: ");
        int user2People = scanner.nextInt();

        // Start booking process
        User user1 = new User(user1Name, user1Mobile, train, user1People, ticketPrice);
        User user2 = new User(user2Name, user2Mobile, train, user2People, ticketPrice);

        System.out.println("\nStarting booking process...");
        user1.start();
        user2.start();

        // Wait for threads to finish
        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nBooking process completed.");
    }
}
