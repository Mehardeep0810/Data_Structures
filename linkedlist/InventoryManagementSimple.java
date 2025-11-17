package Assignment.linkedlist;

import java.util.Scanner;

import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head = null;

    void addAtBeginning(String name, int id, int quantity, double price) {
        Item newNode = new Item(name, id, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(String name, int id, int quantity, double price) {
        Item newNode = new Item(name, id, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item newNode = new Item(name, id, quantity, price);
        Item temp = head;
        for (int i = 1; temp.next != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory empty.");
            return;
        }
        if (head.id == id) {
            head = head.next;
            System.out.println("Removed item with ID " + id);
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Removed item with ID " + id);
        }
    }

    void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Updated quantity for ID " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("Found: " + temp.name + " | ID=" + temp.id +
                                   " | Qty=" + temp.quantity + " | Price=" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + " | ID=" + temp.id +
                                   " | Qty=" + temp.quantity + " | Price=" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value = " + total);
    }

    void sortByName(boolean ascending) {
        if (head == null) return;
        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean condition = i.name.compareToIgnoreCase(j.name) > 0;
                if (!ascending) condition = !condition;
                if (condition) swap(i, j);
            }
        }
    }

    void sortByPrice(boolean ascending) {
        if (head == null) return;
        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                boolean condition = i.price > j.price;
                if (!ascending) condition = !condition;
                if (condition) swap(i, j);
            }
        }
    }

    void swap(Item a, Item b) {
        String tmpName = a.name; a.name = b.name; b.name = tmpName;
        int tmpId = a.id; a.id = b.id; b.id = tmpId;
        int tmpQty = a.quantity; a.quantity = b.quantity; b.quantity = tmpQty;
        double tmpPrice = a.price; a.price = b.price; b.price = tmpPrice;
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No items.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory:");
        while (temp != null) {
            System.out.println(temp.name + " | ID=" + temp.id +
                               " | Qty=" + temp.quantity + " | Price=" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagementSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inv = new Inventory();
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Display All");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Qty: "); int q = sc.nextInt();
                    System.out.print("Price: "); double p = sc.nextDouble();
                    sc.nextLine();
                    inv.addAtBeginning(n, id, q, p);
                }
                case 2 -> {
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Qty: "); int q = sc.nextInt();
                    System.out.print("Price: "); double p = sc.nextDouble();
                    sc.nextLine();
                    inv.addAtEnd(n, id, q, p);
                }
                case 3 -> {
                    System.out.print("Position: "); int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("ID: "); int id = sc.nextInt();
                    System.out.print("Qty: "); int q = sc.nextInt();
                    System.out.print("Price: "); double p = sc.nextDouble();
                    sc.nextLine();
                    inv.addAtPosition(pos, n, id, q, p);
                }
                case 4 -> {
                    System.out.print("ID to remove: "); int id = sc.nextInt();
                    inv.removeById(id);
                }
                case 5 -> {
                    System.out.print("ID to update: "); int id = sc.nextInt();
                    System.out.print("New Qty: "); int q = sc.nextInt();
                    inv.updateQuantity(id, q);
                }
                case 6 -> {
                    System.out.print("ID to search: "); int id = sc.nextInt();
                    inv.searchById(id);
                }
                case 7 -> {
                    System.out.print("Name to search: "); String n = sc.nextLine();
                    inv.searchByName(n);
                }
                case 8 -> inv.calculateTotalValue();
                case 9 -> {
                    System.out.print("Ascending? (true/false): "); boolean asc = sc.nextBoolean();
                    sc.nextLine();
                    inv.sortByName(asc);
                }
                case 10 -> {
                    System.out.print("Ascending? (true/false): "); boolean asc = sc.nextBoolean();
                    sc.nextLine();
                    inv.sortByPrice(asc);
                }
                case 11 -> inv.displayAll();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
