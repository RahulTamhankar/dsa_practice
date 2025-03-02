package stack.nearest;
import java.util.Stack;
import java.util.Vector;

//AKA Nearest Largest Element
public class nearestGreaterToRight {
    public static Vector<Integer> nearestGreaterRight(int[] arr) {
        int size = arr.length;
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();

        // Traverse the array from right to left
        for (int i = size - 1; i >= 0; i--) {
            // If stack is empty, no greater element found
            if (s.size() == 0) {
                v.add(-1);
            }
            // If top of stack is greater than the current element
            else if (s.size() > 0 && s.peek() > arr[i]) {
                v.add(s.peek());
            }
            // If top of stack is smaller or equal to the current element
            else if (s.size() > 0 && s.peek() <= arr[i]) {
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

        // Reverse the vector to maintain the order
        Vector<Integer> result = new Vector<>();
        for (int i = v.size() - 1; i >= 0; i--) {
            result.add(v.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample array
        int[] arr = {4, 5, 2, 10, 8};

        // Call the method to find nearest greater elements to the right
        Vector<Integer> result = nearestGreaterRight(arr);

        // Print the result
        System.out.println(result);
    }

}
//In all 7 questions before misconcepts same code