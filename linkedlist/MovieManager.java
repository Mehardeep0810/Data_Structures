package Assignment.linkedlist;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head = null;
    Movie tail = null;

    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addAtEnd(String title, String director, int year, double rating) {
        Movie newNode = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void addAtPosition(int pos, String title, String director, int year, double rating) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newNode = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 1; temp.next != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        if (temp.next != null) temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        if (newNode.next == null) tail = newNode;
    }

    void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
        System.out.println("Removed movie: " + title);
    }

    void searchByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director " + director);
    }

    void searchByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating);
    }

    void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    void displayForward() {
        Movie temp = head;
        if (temp == null) {
            System.out.println("No movies.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    void displayReverse() {
        Movie temp = tail;
        if (temp == null) {
            System.out.println("No movies.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Director: "); String d = sc.nextLine();
                    System.out.print("Year: "); int y = sc.nextInt();
                    System.out.print("Rating: "); double r = sc.nextDouble();
                    sc.nextLine();
                    list.addAtBeginning(t, d, y, r);
                }
                case 2 -> {
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Director: "); String d = sc.nextLine();
                    System.out.print("Year: "); int y = sc.nextInt();
                    System.out.print("Rating: "); double r = sc.nextDouble();
                    sc.nextLine();
                    list.addAtEnd(t, d, y, r);
                }
                case 3 -> {
                    System.out.print("Position: "); int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Director: "); String d = sc.nextLine();
                    System.out.print("Year: "); int y = sc.nextInt();
                    System.out.print("Rating: "); double r = sc.nextDouble();
                    sc.nextLine();
                    list.addAtPosition(pos, t, d, y, r);
                }
                case 4 -> {
                    System.out.print("Title to remove: "); String t = sc.nextLine();
                    list.removeByTitle(t);
                }
                case 5 -> {
                    System.out.print("Director to search: "); String d = sc.nextLine();
                    list.searchByDirector(d);
                }
                case 6 -> {
                    System.out.print("Rating to search: "); double r = sc.nextDouble();
                    sc.nextLine();
                    list.searchByRating(r);
                }
                case 7 -> {
                    System.out.print("Title to update: "); String t = sc.nextLine();
                    System.out.print("New Rating: "); double r = sc.nextDouble();
                    sc.nextLine();
                    list.updateRating(t, r);
                }
                case 8 -> list.displayForward();
                case 9 -> list.displayReverse();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}

