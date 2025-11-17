package Assignment.linkedlist;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int id;
    boolean available;
    Book next;
    Book prev;

    Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head = null;
    Book tail = null;

    void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        Book temp = head;
        for (int i = 1; temp.next != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        newBook.next = temp.next;
        if (temp.next != null) temp.next.prev = newBook;
        temp.next = newBook;
        newBook.prev = temp;
        if (newBook.next == null) tail = newBook;
    }

    void removeById(int id) {
        if (head == null) {
            System.out.println("Library empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.id != id) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }
        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
        System.out.println("Removed book with ID " + id);
    }

    void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by " + author);
    }

    void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = status;
                System.out.println("Updated availability for ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No books.");
            return;
        }
        Book temp = head;
        System.out.println("Books (Forward):");
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    void displayReverse() {
        if (tail == null) {
            System.out.println("No books.");
            return;
        }
        Book temp = tail;
        System.out.println("Books (Reverse):");
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books = " + count);
    }

    void printBook(Book b) {
        System.out.println("Title=" + b.title + " | Author=" + b.author +
                           " | Genre=" + b.genre + " | ID=" + b.id +
                           " | Available=" + (b.available ? "Yes" : "No"));
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Count Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Author: "); String a = sc.nextLine();
                    System.out.print("Genre: "); String g = sc.nextLine();
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Available (true/false): "); boolean av = sc.nextBoolean();
                    sc.nextLine();
                    lib.addAtBeginning(t, a, g, id, av);
                }
                case 2 -> {
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Author: "); String a = sc.nextLine();
                    System.out.print("Genre: "); String g = sc.nextLine();
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Available (true/false): "); boolean av = sc.nextBoolean();
                    sc.nextLine();
                    lib.addAtEnd(t, a, g, id, av);
                }
                case 3 -> {
                    System.out.print("Position: "); int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Author: "); String a = sc.nextLine();
                    System.out.print("Genre: "); String g = sc.nextLine();
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Available (true/false): "); boolean av = sc.nextBoolean();
                    sc.nextLine();
                    lib.addAtPosition(pos, t, a, g, id, av);
                }
                case 4 -> {
                    System.out.print("Book ID to remove: "); int id = sc.nextInt();
                    lib.removeById(id);
                }
                case 5 -> {
                    System.out.print("Title to search: "); String t = sc.nextLine();
                    lib.searchByTitle(t);
                }
                case 6 -> {
                    System.out.print("Author to search: "); String a = sc.nextLine();
                    lib.searchByAuthor(a);
                }
                case 7 -> {
                    System.out.print("Book ID to update: "); int id = sc.nextInt();
                    System.out.print("Available (true/false): "); boolean av = sc.nextBoolean();
                    sc.nextLine();
                    lib.updateAvailability(id, av);
                }
                case 8 -> lib.displayForward();
                case 9 -> lib.displayReverse();
                case 10 -> lib.countBooks();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}

