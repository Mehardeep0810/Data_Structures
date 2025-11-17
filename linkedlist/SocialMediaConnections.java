package Assignment.linkedlist;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friends;   // list of friend IDs
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    User head = null;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    User searchById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    User searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriendConnection(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!u1.friends.contains(id2)) u1.friends.add(id2);
        if (!u2.friends.contains(id1)) u2.friends.add(id1);
        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    void removeFriendConnection(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        u1.friends.remove(Integer.valueOf(id2));
        u2.friends.remove(Integer.valueOf(id1));
        System.out.println("Friend connection removed between " + u1.name + " and " + u2.name);
    }

    void displayFriends(int id) {
        User u = searchById(id);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + u.name + ":");
        if (u.friends.isEmpty()) {
            System.out.println("No friends.");
            return;
        }
        for (int fid : u.friends) {
            User f = searchById(fid);
            if (f != null) System.out.println(f.name + " (ID=" + f.userId + ")");
        }
    }

    void findMutualFriends(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.println("Mutual friends of " + u1.name + " and " + u2.name + ":");
        boolean found = false;
        for (int fid : u1.friends) {
            if (u2.friends.contains(fid)) {
                User f = searchById(fid);
                if (f != null) {
                    System.out.println(f.name + " (ID=" + f.userId + ")");
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No mutual friends.");
    }

    void countFriends(int id) {
        User u = searchById(id);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println(u.name + " has " + u.friends.size() + " friends.");
    }

    void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in system.");
            return;
        }
        User temp = head;
        System.out.println("All Users:");
        while (temp != null) {
            System.out.println("ID=" + temp.userId + ", Name=" + temp.name + ", Age=" + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaConnections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends of User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by ID");
            System.out.println("7. Search User by Name");
            System.out.println("8. Count Friends of User");
            System.out.println("9. Display All Users");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.print("User ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt();
                    sm.addUser(id, name, age);
                }
                case 2 -> {
                    System.out.print("User1 ID: "); int id1 = sc.nextInt();
                    System.out.print("User2 ID: "); int id2 = sc.nextInt();
                    sm.addFriendConnection(id1, id2);
                }
                case 3 -> {
                    System.out.print("User1 ID: "); int id1 = sc.nextInt();
                    System.out.print("User2 ID: "); int id2 = sc.nextInt();
                    sm.removeFriendConnection(id1, id2);
                }
                case 4 -> {
                    System.out.print("User ID: "); int id = sc.nextInt();
                    sm.displayFriends(id);
                }
                case 5 -> {
                    System.out.print("User1 ID: "); int id1 = sc.nextInt();
                    System.out.print("User2 ID: "); int id2 = sc.nextInt();
                    sm.findMutualFriends(id1, id2);
                }
                case 6 -> {
                    System.out.print("User ID: "); int id = sc.nextInt();
                    User u = sm.searchById(id);
                    if (u != null) System.out.println("Found: " + u.name + " (Age=" + u.age + ")");
                    else System.out.println("User not found.");
                }
                case 7 -> {
                    System.out.print("Name: "); String name = sc.nextLine();
                    User u = sm.searchByName(name);
                    if (u != null) System.out.println("Found: ID=" + u.userId + ", Age=" + u.age);
                    else System.out.println("User not found.");
                }
                case 8 -> {
                    System.out.print("User ID: "); int id = sc.nextInt();
                    sm.countFriends(id);
                }
                case 9 -> sm.displayAllUsers();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}

