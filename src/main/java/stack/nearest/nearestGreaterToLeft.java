package stack.nearest;

import java.util.Stack;
import java.util.Vector;

// AKA Nearest Larger Element to the Left
public class nearestGreaterToLeft {

    public static Vector<Integer> nearestGreaterLeft(int[] arr) {
        int size = arr.length;
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        // Traverse the array from left to right
        for (int i = 0; i < size; i++) { //only this changes as compared to right and reverse not needed in the end
            // If stack is empty, no greater element found on the left
            if (s.size() == 0) {
                v.add(-1);
            }
            // If top of stack is greater than the current element
            else if (s.size() > 0 && s.peek() > arr[i]) {
                v.add(s.peek());
            }
            // If top of stack is smaller or equal to the current element
            else if (s.size() > 0 && s.peek() <= arr[i]) {
                // Pop elements from the stack while they are smaller or equal to current element
                while (s.size() > 0 && s.peek() <= arr[i]) {
                    s.pop();
                }
                // If stack is empty after popping, no greater element
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

        // Call the method to find nearest greater elements to the left
        Vector<Integer> result = nearestGreaterLeft(arr);

        // Print the result
        System.out.println(result);  // Expected output: [-1, -1, 5, -1, 10]
    }
}
