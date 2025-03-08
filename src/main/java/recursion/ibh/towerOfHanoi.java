package recursion.ibh;

public class towerOfHanoi {
    public static void main(String[] args) {
        int n = 3;  // You can change this value to test with different numbers of plates
        int s = 1, d = 2, h = 3;  // Rods represented as integers: source = 1, destination = 2, auxiliary = 3
        solve(n, s, d, h);
    }

    // Method to solve the Tower of Hanoi problem recursively
    public static void solve(int n, int s, int d, int h) {
        // Base case: If there's only one disk, move it directly
        if (n == 1) {
            System.out.println("Moving plate " + n + " from " + s + " to " + d);
            return;
        }

        // Recursive case: Move n-1 disks from source to auxiliary rod
        solve(n - 1, s, h, d);

        // Move the nth disk from source to destination rod
        System.out.println("Moving plate " + n + " from " + s + " to " + d);

        // Move the n-1 disks from auxiliary rod to destination rod
        solve(n - 1, h, d, s);
    }
}
