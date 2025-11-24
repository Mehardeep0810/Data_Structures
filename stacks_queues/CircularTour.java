package Assignment.stacks_queues;

public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += petrol[i] - distance[i];
            if (surplus < 0) {
                // Cannot reach pump i+1 from current start
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        // If total petrol >= total distance, return start
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        if (start != -1) {
            System.out.println("Start at pump index: " + start);
        } else {
            System.out.println("No feasible starting point.");
        }
    }
}
