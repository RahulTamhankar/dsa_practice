package binarysearch;

public class searchingInaNearlySortedArray {

    // Method to search the element in a nearly sorted array
    public static int search(int[] arr, int start, int end, int key) {
        // If the array is empty or invalid range
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        // If the element at mid is the key, return mid
        if (arr[mid] == key) {
            return mid;
        }

        // If element is at mid - 1, return mid - 1
        if (mid - 1 >= start && arr[mid - 1] == key) {
            return mid - 1;
        }

        // If element is at mid + 1, return mid + 1
        if (mid + 1 <= end && arr[mid + 1] == key) {
            return mid + 1;
        }

        // If the element is not found at mid, mid-1, or mid+1, continue with binary search
        if (arr[mid] > key) {
            return search(arr, start, mid - 2, key); // Search left half
        } else {
            return search(arr, mid + 2, end, key); // Search right half
        }
    }

    // Main method to test the search functionality
    public static void main(String[] args) {
        // Test Case 1: Nearly sorted array and target exists
        int[] arr1 = {10, 3, 40, 20, 50, 80, 70};
        int key1 = 40;
        int result1 = search(arr1, 0, arr1.length - 1, key1);
        System.out.println("Index of " + key1 + ": " + result1); // Expected: 2

        // Test Case 2: Nearly sorted array and target does not exist
        int[] arr2 = {10, 3, 40, 20, 50, 80, 70};
        int key2 = 100;
        int result2 = search(arr2, 0, arr2.length - 1, key2);
        System.out.println("Index of " + key2 + ": " + result2); // Expected: -1
    }
}


//Alternative logic to handle first and last elem - Modulo- little expensive
//package binarysearch;
//
//public class SearchingInANearlySortedArray {
//
//    // Method to search the element in a nearly sorted array
//    public static int binarySearch(int[] arr, int target) {
//        int low = 0;
//        int high = arr.length - 1;
//        int n = arr.length;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            // If the element at mid is the target, return mid
//            if (arr[mid] == target) {
//                return mid;
//            }
//
//            // Check if element is at mid-1
//            int previous = (mid - 1 + n) % n;  // Using modulo for wrapping around
//            if (arr[previous] == target) {
//                return previous;
//            }
//
//            // Check if element is at mid+1
//            int next = (mid + 1) % n;  // Using modulo for wrapping around
//            if (arr[next] == target) {
//                return next;
//            }
//
//            // Adjust the search space
//            if (arr[mid] > target) {
//                high = mid - 2;  // Search left half
//            } else {
//                low = mid + 2;   // Search right half
//            }
//        }
//
//        return -1;  // Target not found
//    }
//
//    // Main method to test the search functionality
//    public static void main(String[] args) {
//        // Test Case 1: Nearly sorted array and target exists
//        int[] arr1 = {10, 3, 40, 20, 50, 80, 70};
//        int target1 = 40;
//        int result1 = binarySearch(arr1, target1);
//        System.out.println("Index of " + target1 + ": " + result1);  // Expected: 2
//
//        // Test Case 2: Nearly sorted array and target does not exist
//        int[] arr2 = {10, 3, 40, 20, 50, 80, 70};
//        int target2 = 100;
//        int result2 = binarySearch(arr2, target2);
//        System.out.println("Index of " + target2 + ": " + result2);  // Expected: -1
//    }
//}