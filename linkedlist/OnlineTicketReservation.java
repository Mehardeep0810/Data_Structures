package Assignment.linkedlist;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;
    Ticket tail = null;

    // Add a new ticket at the end
    void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head; // circular link
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully for " + customer);
    }

    // Remove a ticket by ID
    void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        Ticket temp = head, prev = tail;
        do {
            if (temp.ticketId == id) {
                if (temp == head && temp == tail) { // only one ticket
                    head = tail = null;
                } else {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                    if (temp == tail) tail = prev;
                }
                System.out.println("Removed ticket ID " + id);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket ID " + id + " not found.");
    }

    // Display all tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("ID=" + temp.ticketId + ", Customer=" + temp.customerName +
                               ", Movie=" + temp.movieName + ", Seat=" + temp.seatNumber +
                               ", Time=" + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by customer name
    void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println("Found: Ticket ID=" + temp.ticketId + ", Movie=" + temp.movieName +
                                   ", Seat=" + temp.seatNumber + ", Time=" + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tickets found for customer " + name);
    }

    // Search by movie name
    void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Found: Ticket ID=" + temp.ticketId + ", Customer=" + temp.customerName +
                                   ", Seat=" + temp.seatNumber + ", Time=" + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tickets found for movie " + movie);
    }

    // Count total tickets
    void countTickets() {
        if (head == null) {
            System.out.println("Total tickets = 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total tickets = " + count);
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice;
        do {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Add Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name");
            System.out.println("5. Search Ticket by Movie Name");
            System.out.println("6. Count Total Tickets");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Ticket ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: "); String customer = sc.nextLine();
                    System.out.print("Movie Name: "); String movie = sc.nextLine();
                    System.out.print("Seat Number: "); String seat = sc.nextLine();
                    System.out.print("Booking Time: "); String time = sc.nextLine();
                    system.addTicket(id, customer, movie, seat, time);
                }
                case 2 -> {
                    System.out.print("Enter Ticket ID to remove: "); int id = sc.nextInt();
                    system.removeTicket(id);
                }
                case 3 -> system.displayTickets();
                case 4 -> {
                    System.out.print("Enter Customer Name: "); String name = sc.nextLine();
                    system.searchByCustomer(name);
                }
                case 5 -> {
                    System.out.print("Enter Movie Name: "); String movie = sc.nextLine();
                    system.searchByMovie(movie);
                }
                case 6 -> system.countTickets();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}

