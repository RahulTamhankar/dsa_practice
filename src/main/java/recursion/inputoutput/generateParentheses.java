package recursion.inputoutput;

import java.util.ArrayList;


//Till now we saw input having string and output also expected string.. but this is extended input output, which has input Integer and output String
// ie data type is not same
public class generateParentheses {

    // Helper function to generate parentheses
    public static ArrayList<String> paran(String op, ArrayList<String> output, Integer o, Integer c) {
        // Base case: when both open and close parentheses are 0, add the current string to the output
        if (o == 0 && c == 0) {
            output.add(op);
            return output;
        }

        // If we can still add open parentheses '(', add it and recurse
        if (o > 0) {
            String op1 = op + "(";
            paran(op1, output, o - 1, c);  // Recurse with one less open parenthesis
        }

        // If we can add close parentheses ')', and we need more close parentheses than open, add it and recurse
        if (c > o) {
            String op2 = op + ")";
            paran(op2, output, o, c - 1);  // Recurse with one less close parenthesis
        }

        return output;  // Return the accumulated result
    }

    public static void main(String[] args) {
        int n = 3;  // Number of pairs of parentheses
        ArrayList<String> output = new ArrayList<>();  // To store the valid parentheses strings
        int o = n;  // Number of open parentheses available
        int c = n;  // Number of close parentheses available
        String op = "";  // Starting string (empty)

        // Call the helper function to generate parentheses
        ArrayList<String> result = paran(op, output, o, c);

        // Print the result
        System.out.println(result);
    }
}
