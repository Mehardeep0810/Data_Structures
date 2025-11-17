package Assignment.linkedlist;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    TextState head = null;
    TextState tail = null;
    TextState current = null;
    int size = 0;
    final int LIMIT = 10;

    // Add new state at the end
    void addState(String content) {
        TextState newState = new TextState(content);

        // If we are in the middle (after undo), discard forward history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countStates();
        }

        if (head == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }
        current = newState;
        size++;

        // Limit history to last 10 states
        if (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo: move to previous state
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo: move to next state
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    void displayCurrent() {
        if (current == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    // Count states (utility for trimming history)
    int countStates() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class UndoRedoEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                }
                case 2 -> editor.undo();
                case 3 -> editor.redo();
                case 4 -> editor.displayCurrent();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        sc.close();
    }
}
