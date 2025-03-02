package stack.nearest;

import java.util.Stack;
import java.util.Vector;

// AKA Nearest Smaller Element to the Left
public class nearestSmallerToLeft {

    public static Vector<Integer> nearestSmallerLeft(int[] arr) {
        int size = arr.length;
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        // Traverse the array from left to right
        for (int i = 0; i < size; i++) {
            // If stack is empty, no smaller element found on the left
            if (s.size() == 0) {
                v.add(-1);
            }
            // If top of stack is smaller than the current element
            else if (s.size() > 0 && s.peek() < arr[i]) {
                v.add(s.peek());
            }
            // If top of stack is greater than or equal to the current element
            else if (s.size() > 0 && s.peek() >= arr[i]) {
                // Pop elements from the stack while they are greater than or equal to the current element
                while (s.size() > 0 && s.peek() >= arr[i]) {
                    s.pop();
                }
                // If stack is empty after popping, no smaller element
                if (s.size() == 0) {
                    v.add(-1);
                } else {
                    v.add(s.peek());
                }
            }
            // Push the current element to stack for future comparisons
            s.push(arr[i]);
        }

        return v;
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {4, 5, 2, 10, 8};

        // Call the method to find nearest smaller elements to the left
        Vector<Integer> result = nearestSmallerLeft(arr);

        // Print the result
        System.out.println(result);  // Expected output: [-1, 4, -1, 2, 2]
    }
}
