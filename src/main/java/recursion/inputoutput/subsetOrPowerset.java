package recursion.inputoutput;


//https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/


//https://leetcode.com/problems/permutations/description/
public class subsetOrPowerset {

    // Function to generate all permutations of the input string
    private static void permutationFind(String input, String output) {
        // Base case: when the input string is empty, print the output string
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        // Take the first character of the input and generate two recursive calls
        // 1. One call does not include this character
        // 2. Another call includes the character
        String out1 = output;
        String out2 = output + input.charAt(0);
        input = input.substring(1);  // Remove the first character from input

        // Recurse with the remaining string
        permutationFind(input, out1);  // Case without including the character
        permutationFind(input, out2);  // Case including the character
    }

    public static void main(String[] args) {
        String input = "AAB";  // Example input string
        String output = "";     // Start with an empty output string
        permutationFind(input, output);  // Call the permutation function
    }

}
