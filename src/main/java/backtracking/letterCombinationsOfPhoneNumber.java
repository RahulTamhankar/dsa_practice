package backtracking;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        // If the input string is empty, return an empty list.
        if (digits.length() == 0) return new ArrayList<>();

        // Mapping of digits to letters (phone keypad mapping).
        String[] phoneMap = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        // List to store the resulting combinations.
        List<String> combinations = new ArrayList<>();

        // Call the helper method to generate all combinations.
        generateCombinations(combinations, digits.toCharArray(), "", phoneMap);

        return combinations;
    }

    private static void generateCombinations(List<String> combinations, char[] digits, String currentCombination, String[] phoneMap) {
        // If the current combination's length matches the number of digits, add it to the result list.
        if (currentCombination.length() == digits.length) {
            combinations.add(currentCombination);
            return;
        }

        // Find the current digit and its corresponding letter map.
        //Why Do We Do This?
        //
        //The digits array (or string) contains characters that represent the digits of the phone number. However, these characters need to be converted
        // into actual integers to index into the phoneMap array and retrieve the corresponding letters.
        //The phoneMap array is indexed by integers (from 2 to 9), but digits is a string (or char array) that contains characters like '2', '3', etc.
        //By subtracting '0', you get the correct integer value (e.g., '2' becomes 2, '3' becomes 3, etc.), which can then be used to index into phoneMap.
        int digitIndex = currentCombination.length();
        int digit = digits[digitIndex] - '0';

        // Loop through all the letters mapped to the current digit.
        for (char letter : phoneMap[digit].toCharArray()) {
            // Recursively build the combination by adding the letter and continuing the process.
            generateCombinations(combinations, digits, currentCombination + letter, phoneMap);
        }
    }

    // Pattern where we loop over items for each index and make recursive calls before N Queens
    //PalindromePart ,word break,phone keypad

    public static void main(String[] args) {
        String digits = "23"; // Example input
        List<String> result = letterCombinations(digits);

        // Output the result
        System.out.println(result); // Expected: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}


//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class LetterCombinationsOfPhoneNumber {
//
//    public static List<String> letterCombinations(String digits) {
//        // If the input string is empty, return an empty list.
//        if (digits.length() == 0) return new ArrayList<>();
//
//        // Mapping of digits to letters (phone keypad mapping).
//        Map<Character, String> mapping = new HashMap<>();
//        mapping.put('2', "abc");
//        mapping.put('3', "def");
//        mapping.put('4', "ghi");
//        mapping.put('5', "jkl");
//        mapping.put('6', "mno");
//        mapping.put('7', "pqrs");
//        mapping.put('8', "tuv");
//        mapping.put('9', "wxyz");
//
//        // List to store the resulting combinations.
//        List<String> combinations = new ArrayList<>();
//
//        // Call the helper method to generate all combinations.
//        generateCombinations(combinations, digits, 0, mapping, "");
//
//        return combinations;
//    }
//
//    // Helper method for backtracking.
//    private static void generateCombinations(List<String> combinations, String digits, int idx, Map<Character, String> mapping, String currStr) {
//        // If the current combination's length matches the number of digits, add it to the result list.
//        if (idx == digits.length()) {
//            combinations.add(currStr);
//            return;
//        }
//
//        // Get the current digit and its corresponding letter map.
//        char ch = digits.charAt(idx);
//        String letters = mapping.get(ch);
//
//        // Loop through all the letters mapped to the current digit.
//        for (char letter : letters.toCharArray()) {
//            // Recursively build the combination by adding the letter.
//            generateCombinations(combinations, digits, idx + 1, mapping, currStr + letter);
//        }
//    }
//
//    public static void main(String[] args) {
//        String digits = "23"; // Example input
//        List<String> result = letterCombinations(digits);
//
//        // Output the result
//        System.out.println(result); // Expected: [ad, ae, af, bd, be, bf, cd, ce, cf]
//    }
//}