package recursion.inputoutput;

public class permutationwCaseChange {

    public static void permutationSpace(String input, String output) {
        // Base case: if input is empty, print the output (permutation)
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Get the first character of the input and create two new versions: lowercase and uppercase
        String op1 = output + input.substring(0, 1).toLowerCase();  // Add the lowercase character
        String op2 = output + input.substring(0, 1).toUpperCase();  // Add the uppercase character

        // Recursively process the remaining input (input.substring(1))
        permutationSpace(input.substring(1), op1);  // Recursive call with lowercase character
        permutationSpace(input.substring(1), op2);  // Recursive call with uppercase character
    }

    public static void main(String[] args) {
        String input = "ab";  // Example input string
        String output = "";    // Start with an empty output string
        permutationSpace(input, output);  // Call the permutation function
    }
}

//Another way
//package recursion.inputoutput;
//
//public class PermutationWithCaseChange {
//
//    public static void permutationSpace(String input, String output) {
//        // Base case: when input is empty, print the output string
//        if (input.length() == 0) {
//            System.out.println(output);
//            return;
//        }
//
//        // Get the first character of the input
//        char currentChar = input.charAt(0);
//
//        // Create two new strings: one with the current character in lowercase, the other in uppercase
//        String op1 = output + Character.toLowerCase(currentChar);  // Lowercase version
//        String op2 = output + Character.toUpperCase(currentChar);  // Uppercase version
//
//        // Recursive call with the rest of the input string (input.substring(1))
//        permutationSpace(input.substring(1), op1);  // Process with lowercase
//        permutationSpace(input.substring(1), op2);  // Process with uppercase
//    }
//
//    public static void main(String[] args) {
//        String input = "ab";  // Example input string
//        String output = "";    // Start with an empty output string
//        permutationSpace(input, output);  // Call the permutation function
//    }
//}
