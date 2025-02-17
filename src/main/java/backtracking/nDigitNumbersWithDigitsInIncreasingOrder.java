package backtracking;

import java.util.ArrayList;

public class nDigitNumbersWithDigitsInIncreasingOrder {

    // Main function to generate increasing numbers with n digits
    public static ArrayList<Integer> increasingNumbers(int n) {
        // A list to hold all valid numbers with n digits
        ArrayList<Integer> numbers = new ArrayList<>();

        // If n is 1, we add numbers from 0 to 9 as they are valid one-digit numbers
        if (n == 1) {
            // For n=1, add each number from 0 to 9 directly to the list
            for (int i = 0; i <= 9; i++) {
                numbers.add(i);
            }
            // Return the list of 1-digit numbers
            return numbers;
        }

        // If n > 1, we need to generate numbers using recursion
        // We start with 0 and need to add digits to form a number of size n
        addNumbers(numbers, 0, n);
        return numbers;  // Return the final list of numbers
    }

    // Helper function to generate numbers using recursion and backtracking
    public static void addNumbers(ArrayList<Integer> numbers, int number, int n) {
        // Base case: if n reaches 0, it means we have generated a valid number with 'n' digits
        if (n == 0) {
            // Add the generated number to the list
            numbers.add(number);
            return;  // Exit the function, as we've reached a complete number
        }

        // Determine the starting point for the next digit
        // 'number % 10' gives the last digit of the current number.
        // We add 1 to this digit because the digits should always increase.
        int start = (number % 10) + 1;

        // Loop through possible digits starting from 'start' (next possible digit) to 9
        for (int j = start; j <= 9; j++) {
            // Build the number by adding the next digit 'j'
            number = (number * 10) + j;

            // Recursively add the next digit
            addNumbers(numbers, number, n - 1);  // Decrease n to add the next digit

            // Backtrack: remove the last digit added (reverse the operation)
            // We subtract the last digit and divide by 10 to go back to the previous state
            number = (number - j) / 10;
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int n = 3; // Example with n = 2 (Generate 2-digit increasing numbers)

        // Call the function to get the result
        ArrayList<Integer> result = increasingNumbers(n);

        // Print the result: all the numbers with increasing digits of size n
        for (int num : result) {
            System.out.println(num);  // Output each number
        }
    }
}

