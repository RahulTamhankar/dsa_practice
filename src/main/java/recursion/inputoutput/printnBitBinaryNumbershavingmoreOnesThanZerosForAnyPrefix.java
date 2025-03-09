package recursion.inputoutput;


//Why is this ip-op method?
//We are given N and for this N there are nplaces which are to be filled
//and each place has 2 choices ie. 1 and 0

import java.util.ArrayList;

public class printnBitBinaryNumbershavingmoreOnesThanZerosForAnyPrefix {

    public static void main(String[] args) {
        int n = 3;  // You can change the value of n as needed
        ArrayList<String> res = new ArrayList<>();

        // Calling the method to generate the binary numbers
        String op = "";
        int ones = 0;
        int zeros = 0;
        solve(ones, zeros, n, op, res);  // Calling the recursive function

        // Print the result
        System.out.println(res);
    }

    // Recursive method to generate binary numbers with more 1's than 0's
    public static void solve(int ones, int zeros, int n, String op, ArrayList<String> res) {
        if (n == 0) {
            res.add(op);  // Add the generated binary string to the result list
            return;
        }

        // Add 1 to the binary string and recurse
        solve(ones + 1, zeros, n - 1, op + "1", res);

        // Add 0 to the binary string only if the number of 1's is greater than 0's
        if (ones > zeros) {
            solve(ones, zeros + 1, n - 1, op + "0", res);
        }
    }
}