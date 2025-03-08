package recursion.inputoutput;

import java.util.ArrayList;

public class letterCasePermutation {

    public static void letterCase(String input, String output, ArrayList<String> result) {
        // Base case: when the input string is empty, add the output to the result
        if (input.length() == 0) {
            result.add(output);
            return;
        }

        // Get the first character of the input string
        char firstChar = input.charAt(0);

        // If the first character is a letter (lowercase or uppercase), explore both possibilities
        if (Character.isLetter(firstChar)) {
            // Lowercase version
            letterCase(input.substring(1), output + Character.toLowerCase(firstChar), result);
            // Uppercase version
            letterCase(input.substring(1), output + Character.toUpperCase(firstChar), result);
        } else {
            // If it's a number, just append it as is
            letterCase(input.substring(1), output + firstChar, result);
        }
    }

    public static void main(String[] args) {
        String input = "a1b2";  // Example input string
        ArrayList<String> result = new ArrayList<>(); // Initialize result list
        letterCase(input, "", result);  // Call the letterCase function with an empty output string
        System.out.println(result);  // Print the result
    }
}
