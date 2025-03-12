package recursion.inputoutput;

import java.util.HashSet;
import java.util.Set;

public class uniqueSubsets {

    // Function to generate all unique subsets of the input string
    private static void permutationFind(String input, String output, Set<String> resultSet) {
        // Base case: when the input string is empty, print the output string
        if(input.length() == 0) {
            // If output is not already in the set, add it to the set and print it
            if (!resultSet.contains(output)) {
                resultSet.add(output);
                System.out.println(output);
            }
            return;
        }

        // Take the first character of the input and generate two recursive calls
        // 1. One call does not include this character
        // 2. Another call includes the character
        String out1 = output;
        String out2 = output + input.charAt(0);
        input = input.substring(1);  // Remove the first character from input

        // Recurse with the remaining string
        permutationFind(input, out1, resultSet);  // Case without including the character
        permutationFind(input, out2, resultSet);  // Case including the character
    }

    public static void main(String[] args) {
        String input = "AAB";  // Example input string
        String output = "";     // Start with an empty output string
        Set<String> resultSet = new HashSet<>();  // Set to store unique subsets
        permutationFind(input, output, resultSet);  // Call the permutation function
    }
}
//Approach 2 using Sorting and then backtracking
//import java.util.*;
//
//public class Solution {
//
//    // List to store all subsets
//    private List<List<Integer>> ans = new ArrayList<>();
//
//    // Function to generate all subsets (backtracking)
//    private void generate(int[] ip, List<Integer> op, int index) {
//        // Base case: when index reaches the size of ip, add the current subset to the result
//        if (index == ip.length) {
//            ans.add(new ArrayList<>(op));  // Add the current subset
//            return;
//        }
//
//        // Case 1: Don't pick the current element (ip[index])
//        generate(ip, op, index + 1);
//
//        // Case 2: Pick the current element (ip[index]) if it's the first occurrence
//        // of the element at this level (avoid duplicates)
//        if (index == 0 || ip[index] != ip[index - 1]) {
//            op.add(ip[index]);  // Include the current element in the subset
//            generate(ip, op, index + 1);
//            op.remove(op.size() - 1);  // Backtrack by removing the last added element
//        }
//    }
//
//    // Function to return all subsets
//    public List<List<Integer>> subsets(int[] nums) {
//        Arrays.sort(nums);  // Sort the input to handle duplicates
//        generate(nums, new ArrayList<>(), 0);  // Call generate to create all subsets
//        return ans;  // Return the result
//    }
//
//    // Main function to test the solution
//    public static void main(String[] args) {
//        Solution sol = new Solution();
//        int[] nums = {1, 2, 2};
//        List<List<Integer>> result = sol.subsets(nums);
//
//        // Print the result
//        for (List<Integer> subset : result) {
//            System.out.println(subset);
//        }
//    }
//}