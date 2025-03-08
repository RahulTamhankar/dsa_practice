package binarysearch.binarysearchonans;

public class allocateMinimumNumberOfPages {
    // Function to check if it's possible to allocate books such that no student reads more than 'max' pages
    public static boolean isValid(int[] arr, int n, int k, int max) {
        int studentCount = 1;  // Start with 1 student
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr[i];

            // If the current student exceeds the maximum pages allowed, allocate a new student
            if (currentSum > max) {
                studentCount++;
                currentSum = arr[i];  // Start counting for the new student

                if (studentCount > k) {  // If more than 'k' students are needed, return false
                    return false;
                }
            }
        }
        return true;  // Allocation is valid
    }

    // Function to find the minimum pages that can be allocated to each student
    public static int allocatePages(int[] arr, int n, int k) {
        int start = 0;
        int end = 0;

        // Find the sum of all pages and the maximum pages in the array
        for (int i = 0; i < n; i++) {
            start = Math.max(start, arr[i]);  // The maximum value is the lower bound (since no student can get less than the largest book)
            end += arr[i];  // The sum of all pages is the upper bound
        }

        int result = -1;

        // Perform binary search on the number of pages
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If it's possible to allocate with 'mid' as the max pages, try for a smaller max
            if (isValid(arr, n, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                // If it's not possible, try with a larger max
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example input: pages in books
        int[] arr = {10, 20, 30, 40};
        int n = arr.length;
        int k = 2;  // Number of students

        // Find the minimum number of pages that can be allocated
        int result = allocatePages(arr, n, k);

        // Output the result
        System.out.println("The minimum number of pages: " + result);
    }
}
