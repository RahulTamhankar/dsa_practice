package dp.eggdrop;

public class eggDropRecursive {

    // Method to solve the egg drop problem recursively
    public static int solve(int eggs, int floors) {
        // Base cases
        if (floors == 0 || floors == 1) {
            return floors;
        }
        if (eggs == 1) {
            return floors;
        }

        int minAttempts = Integer.MAX_VALUE;

        // Try dropping an egg from each floor and take the minimum of the maximum attempts
        //This +1 represents the current floor's drop and ensures that we're counting the
        // attempt we're considering (i.e., the first drop at floor i).
        for (int i = 1; i <= floors; i++) {
            int temp = 1 + Math.max(solve(eggs, floors - i), solve(eggs - 1, i - 1));
            minAttempts = Math.min(minAttempts, temp);
        }

        return minAttempts;
    }

    public static void main(String[] args) {
        int eggs = 3;
        int floors = 5;

        // Call the solve method and display the result
        int attempts = solve(eggs, floors);
        System.out.println("# of attempts: " + attempts);
    }
}

