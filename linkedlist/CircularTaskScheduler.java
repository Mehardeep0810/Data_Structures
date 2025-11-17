package Assignment.linkedlist;

import java.util.Scanner;

class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head = null;
    Task current = null;

    void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newNode = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newNode;
            head.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task newNode = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; temp.next != head && i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        if (head.id == id) {
            if (head.next == head) {
                head = null;
                current = null;
            } else {
                Task temp = head;
                while (temp.next != head) temp = temp.next;
                temp.next = head.next;
                head = head.next;
            }
            System.out.println("Removed task with ID " + id);
            return;
        }
        Task temp = head;
        while (temp.next != head && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next.id == id) {
            temp.next = temp.next.next;
            System.out.println("Removed task with ID " + id);
        } else {
            System.out.println("Task not found.");
        }
    }

    void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks.");
            return;
        }
        System.out.println("Current Task: ID=" + current.id + ", Name=" + current.name +
                           ", Priority=" + current.priority + ", DueDate=" + current.dueDate);
    }

    void moveToNextTask() {
        if (current != null) current = current.next;
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Task temp = head;
        System.out.println("Tasks:");
        do {
            System.out.println("ID=" + temp.id + ", Name=" + temp.name +
                               ", Priority=" + temp.priority + ", DueDate=" + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: ID=" + temp.id + ", Name=" + temp.name +
                                   ", Priority=" + temp.priority + ", DueDate=" + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks with priority " + priority);
    }
}

public class CircularTaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Priority: "); int p = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: "); String d = sc.nextLine();
                    scheduler.addAtBeginning(id, name, p, d);
                }
                case 2 -> {
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Priority: "); int p = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: "); String d = sc.nextLine();
                    scheduler.addAtEnd(id, name, p, d);
                }
                case 3 -> {
                    System.out.print("Position: "); int pos = sc.nextInt();
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Priority: "); int p = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Due Date: "); String d = sc.nextLine();
                    scheduler.addAtPosition(pos, id, name, p, d);
                }
                case 4 -> {
                    System.out.print("Task ID to remove: "); int id = sc.nextInt();
                    scheduler.removeById(id);
                }
                case 5 -> scheduler.viewCurrentTask();
                case 6 -> scheduler.moveToNextTask();
                case 7 -> scheduler.displayAll();
                case 8 -> {
                    System.out.print("Priority to search: "); int p = sc.nextInt();
                    scheduler.searchByPriority(p);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
