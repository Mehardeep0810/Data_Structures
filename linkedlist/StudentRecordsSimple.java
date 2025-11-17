package Assignment.linkedlist;

import java.util.Scanner;

class Student {
    int roll;
    String name;
    int age;
    String grade;
    Student next;

    Student(int roll, String name, int age, String grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentList {
    Student head = null; 

    void addAtBeginning(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    void addAtEnd(int roll, String name, int age, String grade) {
        Student newNode = new Student(roll, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void addAtPosition(int pos, int roll, String name, int age, String grade) {
        if (pos <= 1 || head == null) {
            addAtBeginning(roll, name, age, grade);
            return;
        }
        Student newNode = new Student(roll, name, age, grade);
        Student temp = head;
        for (int i = 1; temp.next != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByRoll(int roll) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.roll == roll) {
            head = head.next;
            System.out.println("Deleted record with roll " + roll);
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Record not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted record with roll " + roll);
        }
    }

    void searchByRoll(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found: Roll=" + temp.roll + ", Name=" + temp.name +
                                   ", Age=" + temp.age + ", Grade=" + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found.");
    }

    void updateGrade(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;
                System.out.println("Updated grade for roll " + roll);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Record not found.");
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No records.");
            return;
        }
        Student temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println("Roll=" + temp.roll + ", Name=" + temp.name +
                               ", Age=" + temp.age + ", Grade=" + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordsSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll");
            System.out.println("5. Search by Roll");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.print("Roll: "); int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Age: "); int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: "); String g = sc.nextLine();
                    list.addAtBeginning(r, n, a, g);
                }
                case 2 -> {
                    System.out.print("Roll: "); int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Age: "); int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: "); String g = sc.nextLine();
                    list.addAtEnd(r, n, a, g);
                }
                case 3 -> {
                    System.out.print("Position: "); int pos = sc.nextInt();
                    System.out.print("Roll: "); int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Age: "); int a = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Grade: "); String g = sc.nextLine();
                    list.addAtPosition(pos, r, n, a, g);
                }
                case 4 -> {
                    System.out.print("Roll to delete: "); int r = sc.nextInt();
                    list.deleteByRoll(r);
                }
                case 5 -> {
                    System.out.print("Roll to search: "); int r = sc.nextInt();
                    list.searchByRoll(r);
                }
                case 6 -> {
                    System.out.print("Roll to update: "); int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Grade: "); String g = sc.nextLine();
                    list.updateGrade(r, g);
                }
                case 7 -> list.displayAll();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}

