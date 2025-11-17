package Assignment.linkedlist;

import java.util.Scanner;

class Process {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class CircularQueue {
    Process head = null;
    Process tail = null;

    void addProcess(int pid, int burstTime, int priority) {
        Process newNode = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    void removeProcess(int pid) {
        if (head == null) return;
        if (head == tail && head.pid == pid) {
            head = tail = null;
            return;
        }
        Process temp = head, prev = tail;
        do {
            if (temp.pid == pid) {
                prev.next = temp.next;
                if (temp == head) head = temp.next;
                if (temp == tail) tail = prev;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void displayQueue() {
        if (head == null) {
            System.out.println("Queue empty.");
            return;
        }
        Process temp = head;
        System.out.print("Processes in queue: ");
        do {
            System.out.print("[PID=" + temp.pid + ", Remaining=" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    boolean isEmpty() {
        return head == null;
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularQueue queue = new CircularQueue();

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Process " + i + " ID: ");
            int pid = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pr = sc.nextInt();
            queue.addProcess(pid, bt, pr);
        }

        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        int totalWaitingTime = 0, totalTurnaroundTime = 0, time = 0;
        Process current = queue.head;

        while (!queue.isEmpty()) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(tq, current.remainingTime);
                current.remainingTime -= execTime;
                time += execTime;

                System.out.println("Executing PID=" + current.pid + " for " + execTime + " units. Remaining=" + current.remainingTime);

                if (current.remainingTime == 0) {
                    int turnaround = time;
                    int waiting = turnaround - current.burstTime;
                    totalTurnaroundTime += turnaround;
                    totalWaitingTime += waiting;
                    System.out.println("Process PID=" + current.pid + " finished. Turnaround=" + turnaround + ", Waiting=" + waiting);
                    queue.removeProcess(current.pid);
                    current = queue.head;
                } else {
                    current = current.next;
                }
                queue.displayQueue();
            }
        }

        double avgWT = (double) totalWaitingTime / n;
        double avgTAT = (double) totalTurnaroundTime / n;
        System.out.println("\nAverage Waiting Time = " + avgWT);
        System.out.println("Average Turnaround Time = " + avgTAT);

        sc.close();
    }
}

