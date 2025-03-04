package binarysearch;  // Declare the package at the top of the file

public class countOfElementInASortedArray {

    // Function to return Lower Bound (First occurrence of the target)
    static int lowerBound(int[] arr, int target) {
        int res = arr.length;  // Default to arr.length if not found

        int lo = 0, hi = arr.length - 1;

        // Binary Search to find the lower bound
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= target) {
                res = mid;  // Update result
                hi = mid - 1;  // Search left half
            } else {
                lo = mid + 1;  // Search right half
            }
        }
        return res;
    }

    // Function to return Upper Bound (Index just after the last occurrence of the target)
    static int upperBound(int[] arr, int target) {
        int res = arr.length;  // Default to arr.length if not found

        int lo = 0, hi = arr.length - 1;

        // Binary Search to find the upper bound
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;  // Update result
                hi = mid - 1;  // Search left half
            } else {
                lo = mid + 1;  // Search right half
            }
        }
        return res;
    }

    // Function to count the frequency of target
    static int countFreq(int[] arr, int target) {
        // Return the difference between upper and lower bound of the target
        //######For sorted all same elements will be in back2back
        return upperBound(arr, target) - lowerBound(arr, target);
    }

    // Driver program
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int target = 2;

        // Output the frequency of the target
        System.out.println(countFreq(arr, target));  // Output should be 4
    }
}
