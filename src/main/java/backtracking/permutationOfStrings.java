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

    private static void solve(int idx, char[] s, List<String> ans) { //start=idx ->it should start from 1st character
        // If we have processed all characters, we have one permutation
        if (idx == s.length) {
            // Convert char array to string/
            //At this point, we convert the current char[] (which represents the permutation) back into a String,
            // because we want the result to be in the form of strings (not characters).
            //Converting char[] to String:
            //String str = new String(s);: We use this to create a new String from the character array s.
            // This is necessary because the permutations are represented by char[] during recursion, but we want
            // to store them as strings in the result list (ans).
            //Once we have this string, we add it to the ans list.
            String str = new String(s);
            ans.add(str);
            return;
        }

        // Set to store unique characters at the current position
        Set<Character> st = new HashSet<>();

        for (int i = idx; i < s.length; i++) {
            // Check if the character is already used at this position
            if (!st.contains(s[i])) {// Control
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



//In Java, the concept of pass-by-reference and pass-by-value behaves a bit differently than in some other languages. Let me clarify how this works with respect to strings and backtracking.
//
//Pass-by-Value in Java
//Java is always pass-by-value, but the way it works for primitive types and objects can lead to confusion:
//
//Primitive Types (e.g., int, char, etc.):
//When you pass a primitive type (like int, char, boolean, etc.) to a method, the actual value is passed. Any changes made to the parameter inside the method do not affect the original value outside the method.
//Objects (e.g., String, ArrayList, etc.):
//When you pass an object (like a String, ArrayList, char[], etc.), you are passing the reference to the object, but not the actual object itself.
//In other words, you are passing a copy of the reference (the memory address where the object is stored), and this is why changes made to the object (like modifying the contents of a char[] or an ArrayList) will affect the original object outside the method.
//However, if you reassign the reference inside the method (e.g., changing the reference to a new object), it will not affect the original object outside the method because you're only modifying the local reference, not the object itself.
//Strings in Java
//Strings are immutable in Java: This means that once a String object is created, it cannot be changed. If you attempt to modify a String object (e.g., through concatenation), a new String object is created, and the original object remains unchanged.
//In your case of backtracking with strings, when you pass a String to a method, you are passing a copy of the reference to that String object. However, since String objects are immutable, you cannot modify the string itself directly inside the method.
//For example:
//
//java
//Copy
//String str = "Hello";
//modifyString(str);
//System.out.println(str);  // Will print "Hello", not the modified string
//
//public static void modifyString(String s) {
//    s = s + " World";  // Creates a new String object
//}
//Even though you modify the string inside modifyString, it won't affect the original str variable in main because strings are immutable. Java creates a new String object when you perform the concatenation.
//
//Backtracking with Strings in Java
//In backtracking, when you use strings, you need to keep in mind that the string itself cannot be modified directly. Instead, you can:
//
//Use a mutable data structure (like a char[] array) to perform swaps or modifications.
//String concatenation (like adding characters) will create new strings, so you would need to pass a new string when making changes.
//In the case of the backtracking permutation code we discussed earlier, you are working with a mutable character array (char[]) for swapping characters, which is perfectly fine. In the recursive process, you modify the char[], and those changes will affect the state of the string as passed between method calls.