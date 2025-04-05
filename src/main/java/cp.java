import java.util.Scanner;

public class cp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases

        // Loop through all test cases
        while (t-- > 0) {
            int n = sc.nextInt();  // Length of the final string
            String s = sc.next();  // The final binary string itself

            int start = 0, end = n - 1;
            int count = 0;

            // Check while start is less than end and characters at start and end are equal
            while (start <= end) {
                if (s.charAt(start) == s.charAt(end)) {
                    break;
                }
                start++;
                end--;
            }

            // Output the length of the shortest possible original string
            System.out.println(end - start + 1);
        }

        sc.close();  // Close the scanner after all test cases are done.
    }
}

