package recursion.inputoutput;

public class permutationwSpaces {

    // Function to generate permutations with spaces between characters
    public static void permutationSpace(String input, String output) {
        // Base case: if the input string is empty, print the current output
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Option 1: add the current character to the output with a space
        String op1 = output + " " + input.charAt(0);

        // Option 2: add the current character without a space
        String op2 = output + input.charAt(0);

        // Recur for the remaining substring
        String remaining = input.substring(1);

        // Call the function recursively for both options
        permutationSpace(remaining, op1);  // With space
        permutationSpace(remaining, op2);  // Without space
    }

    public static void main(String[] args) {
        String input = "ABC";  // Example input string
        String output = "";     // Start with an empty output string
        permutationSpace(input, output);  // Call the permutation function
    }
}
