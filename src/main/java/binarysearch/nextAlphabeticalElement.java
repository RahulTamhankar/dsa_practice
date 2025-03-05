package binarysearch;

public class nextAlphabeticalElement {

    // Method to find the next greatest letter after the target in the letters array
    public static char nextGreatestLetter(char[] letters, char target) {
        char res = '#';  // Default value to represent no result

        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If the element at mid is equal to target, move right to find the next greater letter
            if (letters[mid] == target) {
                start = mid + 1;
            }
            // If target is less than letters[mid], it may be the next greater letter
            else if (target < letters[mid]) {
                res = letters[mid];  // Update res with the next greatest letter
                end = mid - 1;  // Continue searching on the left
            }
            // If target is greater than letters[mid], move right
            else {
                start = mid + 1;
            }
        }

        // If no result was found, return the first element (the smallest element)
        if (res == '#') {
            return letters[0];
        }

        return res;
    }

    // Main method to test the nextGreatestLetter function
    public static void main(String[] args) {
        // Test Case 1: Letters array and a target character
        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';

        char result1 = nextGreatestLetter(letters1, target1);
        System.out.println("Next greatest letter after '" + target1 + "' is: " + result1);  // Expected: 'c'

        // Test Case 2: Target is greater than all elements in the array
        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'k';

        char result2 = nextGreatestLetter(letters2, target2);
        System.out.println("Next greatest letter after '" + target2 + "' is: " + result2);  // Expected: 'c'

        // Test Case 3: Target matches an element in the array
        char[] letters3 = {'c', 'f', 'j'};
        char target3 = 'f';

        char result3 = nextGreatestLetter(letters3, target3);
        System.out.println("Next greatest letter after '" + target3 + "' is: " + result3);  // Expected: 'j'

        // Test Case 4: Target is smaller than all elements
        char[] letters4 = {'c', 'f', 'j'};
        char target4 = 'a';

        char result4 = nextGreatestLetter(letters4, target4);
        System.out.println("Next greatest letter after '" + target4 + "' is: " + result4);  // Expected: 'c'
    }
}
