package dp.scrambledstring;

public class scrambledStringRecursive {

    // Recursive helper function to check if strings a and b can be scrambled
    public boolean solve(String a, String b) {
        int n = a.length();

        // If the strings are equal, they are scrambled versions of each other
        if (a.equals(b)) return true;

        // If the lengths of strings are less than 1, return false
        if (a.length() < 1) {
            return false;
        }

        boolean flag = false;

        // Try splitting the string in every possible way
        for (int i = 1; i <= n - 1; i++) {

            // Check the case where we do not swap
            boolean noswap = solve(a.substring(0, i), b.substring(0, i)) &&
                    solve(a.substring(i), b.substring(i));

            // Check the case where we do swap
            boolean swap = solve(a.substring(0, i), b.substring(n - i)) &&
                    solve(a.substring(i), b.substring(0, n - i));

            // If either swap or no swap is possible, mark it as true
            if (swap || noswap) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    // Main function to check if one string is a scrambled version of the other
    public boolean isScramble(String s1, String s2) {
        // If the lengths of the strings are not equal, return false
        if (s1.length() != s2.length()) return false;

        // If both strings are empty, return true
        if (s1.length() == 0 && s2.length() == 0) return true;

        // Use the recursive helper function to determine if the strings are scrambled
        return solve(s1, s2);
    }

    // Main method to test the solution
    public static void main(String[] args) {
        scrambledStringRecursive solution = new scrambledStringRecursive();

        String s1 = "great";
        String s2 = "rgeat";

        // Check if s2 is a scrambled string of s1
        boolean result = solution.isScramble(s1, s2);

        // Print the result
        System.out.println("Is \"" + s2 + "\" a scrambled version of \"" + s1 + "\"? " + result);
    }
}
