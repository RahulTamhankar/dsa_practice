package stack.miscconcepts;

import java.util.Stack;

public class implementingAMinStack {
    Stack<Integer> s = new Stack<>(), ss = new Stack<>(); // Main stack and Min stack

    public implementingAMinStack() {
        // No need for initialization as it's done in the declaration
    }

    // Push an element to the stack
    public void push(int a) {
        s.push(a); // Push to the main stack

        // Push to the min stack if it's empty, or the current element is smaller or equal to the current minimum
        if (ss.isEmpty() || ss.peek() >= a) {
            ss.push(a);
        }
    }

    // Pop the top element from the stack
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        int ans = s.pop();  // Pop from the main stack

        // If the popped element is the same as the current minimum, pop from the min stack as well
        if (ss.peek() == ans) {
            ss.pop();
        }

        return ans;
    }

    // Get the minimum element from the stack
    public int getMin() {
        if (ss.isEmpty()) {
            return -1;
        }
        return ss.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return s.isEmpty();
    }

    // Check if the stack is full (assuming a size limit, for example purposes)
    public boolean isFull() {
        // For simplicity, let's assume the stack can hold 100 elements at max
        return s.size() == 100;
    }

    public static void main(String[] args) {
        implementingAMinStack stack = new implementingAMinStack();

        stack.push(5);
        System.out.println(stack.getMin());  // Output: 5
        stack.push(3);
        System.out.println(stack.getMin());  // Output: 3
        stack.push(7);
        System.out.println(stack.getMin());  // Output: 3

        System.out.println(stack.pop());     // Output: 7
        System.out.println(stack.getMin());  // Output: 3

        stack.push(2);
        System.out.println(stack.getMin());  // Output: 2
    }
}
