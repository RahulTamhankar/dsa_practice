package backtracking;

import java.util.*;

public class permutationOfStrings {

    // Method to find all unique permutations of the string in lexicographically sorted order
    public static List<String> find_permutation(String s) {
        List<String> ans = new ArrayList<>();
        //What is ans?
        //This is where we store the results of all the generated permutations. As we generate permutations,
        // we need a way to collect and store them. ans is a List<String> that will contain all the permutations as strings.
        //Why an ArrayList?
        //An ArrayList is a good choice because it's a resizable array, which makes it easy to add new permutations
        // as we generate them in the recursive process.


        char[] schar = s.toCharArray();  // Convert String to char array
        //The reason for this is that strings in Java are immutable, meaning
        // you cannot change individual characters in a String.
        // In order to perform operations such as swapping characters,
        // we need to use a mutable data structure, which is why we convert
        // the input string s into a char array.

        // Sort the char array to ensure lexicographical order
        Arrays.sort(schar);

        // Call the recursive helper function
        solve(0, schar, ans);

        return ans;
    }

    private static void solve(int idx, char[] s, List<String> ans) {
        // If we have processed all characters, we have one permutation
        if (idx == s.length) {
            // Convert char array to string/
            //At this point, we convert the current char[] (which represents the permutation) back into a String, because we want the result to be in the form of strings (not characters).
            //Converting char[] to String:
            //String str = new String(s);: We use this to create a new String from the character array s. This is necessary because the permutations are represented by char[] during recursion, but we want to store them as strings in the result list (ans).
            //Once we have this string, we add it to the ans list.
            String str = new String(s);
            ans.add(str);
            return;
        }

        // Set to store unique characters at the current position
        Set<Character> st = new HashSet<>();

        for (int i = idx; i < s.length; i++) {
            // Check if the character is already used at this position
            if (!st.contains(s[i])) {
                st.add(s[i]);

                // Swap the current character to the current position
                swap(s, idx, i);

                // Recur for the next position
                solve(idx + 1, s, ans);

                // Swap back (backtrack)
                swap(s, idx, i);
            }
        }
    }

    private static void swap(char[] s, int idx, int i) {
        char temp = s[idx];
        s[idx] = s[i];
        s[i] = temp;
    }

    public static void main(String[] args) {
        String s = "ABC";  // Input string
        List<String> result = find_permutation(s);

        // Print the result in lexicographically sorted order
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}
