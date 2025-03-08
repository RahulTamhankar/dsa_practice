package recursion;

public class kthSymbolinGrammar {
    // Function to find the kth symbol in the nth row
    public static int kthGrammar(int n, int k) {
        // Base case: the first row always contains a single '0'
        if (n == 1 && k == 1) {
            return 0;
        }

        // Find the midpoint of the current row
        int mid = (int) Math.pow(2, n - 1) / 2;
//Example of Row Lengths:
//Row 1: Length = 2^0 = 1
//Row 2: Length = 2^1 = 2
//Row 3: Length = 2^2 = 4
//Row 4: Length = 2^3 = 8


        // If k is in the first half, the answer is the same as the (n-1)th row at position k
        if (k <= mid) {
            return kthGrammar(n - 1, k);
        }
        // If k is in the second half, we calculate the result by flipping the symbol
        else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }

    public static void main(String[] args) {
        // Test case 1: n = 1, k = 1
        System.out.println(kthGrammar(1, 1));  // Output: 0

        // Test case 2: n = 2, k = 1
        System.out.println(kthGrammar(2, 1));  // Output: 0

        // Test case 3: n = 2, k = 2
        System.out.println(kthGrammar(2, 2));  // Output: 1

        // Test case 4: n = 3, k = 2
        System.out.println(kthGrammar(3, 2));  // Output: 1

        // Test case 5: n = 3, k = 4
        System.out.println(kthGrammar(3, 4));  // Output: 0
    }

}
