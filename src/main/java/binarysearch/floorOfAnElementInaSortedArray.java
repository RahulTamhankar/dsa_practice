package binarysearch;

public class floorOfAnElementInaSortedArray {
    // Method to find the floor of an element in a sorted array
    public static int findFloor(long[] v, long n, long x) {
        int res = -1;  // Initialize result as -1, in case the floor does not exist

        // Handle the edge case when the array has only one element
        if (n == 1) {
            if (v[0] <= x) {
                return 0;  // Return index 0 if the only element is <= x
            } else {
                return -1;  // Return -1 if the only element is > x
            }
        }

        int first = 0, last = (int) n - 1, mid;

        // Perform binary search to find the floor
        while (first <= last) {
            mid = first + (last - first) / 2;

            // If the element at mid is equal to x, return the index as the floor
            if (v[mid] == x) {
                return mid;
            }

            // If the element at mid is less than x, it could be the floor
            if (v[mid] < x) {
                res = mid;  // Update res to mid, as it's a potential floor
                first = mid + 1;  // Move to the right half to search for a bigger floor
            } else {
                last = mid - 1;  // Move to the left half to search for a smaller floor
            }
        }

        return res;  // Return the index of the floor, or -1 if no floor exists
    }

    // Main method to test the findFloor method
    public static void main(String[] args) {
        // Test Case 1: Array with floor found
        long[] arr1 = {1, 2, 8, 10, 10, 12, 19};
        long x1 = 5;
        int result1 = findFloor(arr1, arr1.length, x1);
        System.out.println("Floor of " + x1 + ": " + result1);  // Expected: 2 (index of 2)

        // Test Case 2: Array with no floor
        long[] arr2 = {1, 2, 8, 10, 10, 12, 19};
        long x2 = 0;
        int result2 = findFloor(arr2, arr2.length, x2);
        System.out.println("Floor of " + x2 + ": " + result2);  // Expected: -1 (no floor exists)

        // Test Case 3: Array with duplicate elements and floor exists
        long[] arr3 = {1, 2, 8, 8, 10, 10, 12, 19};
        long x3 = 8;
        int result3 = findFloor(arr3, arr3.length, x3);
        System.out.println("Floor of " + x3 + ": " + result3);  // Expected: 2 (index of 8)

        // Test Case 4: Array with single element
        long[] arr4 = {5};
        long x4 = 5;
        int result4 = findFloor(arr4, arr4.length, x4);
        System.out.println("Floor of " + x4 + ": " + result4);  // Expected: 0 (index of 5)
    }
}


//Which one is correct?
//Both codes are correct, but they serve different purposes:
//
//Code 1 is designed for a "nearly sorted array" where elements can be swapped with adjacent ones (not strictly sorted). It adjusts the search by checking adjacent positions (mid-1, mid+1).
//
//Code 2 works well for a strictly sorted array and efficiently finds the floor using standard binary search.
//
//When to use each one:
//Use Code 2 if you're working with a strictly sorted array and need the floor element.
//Use Code 1 if you're working with a nearly sorted array where elements can be swapped with their adjacent elements (as mentioned in your problem description).


//import java.io.*;
//
//class GFG {
//
//    /* Iterative function to find the floor of x using binary search */
//    static int floorSearch(int arr[], int n, int x) {
//        int low = 0, high = n - 1;
//        int result = -1;
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            if (arr[mid] == x)
//                return mid;
//
//            if (arr[mid] < x) {
//                result = mid; // Possible floor
//                low = mid + 1; // Move right
//            } else {
//                high = mid - 1; // Move left
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        int arr[] = {1, 2, 4, 6, 10, 12, 14};
//        int n = arr.length;
//        int x = 7;
//
//        // Function call
//        int index = floorSearch(arr, n, x);
//        if (index == -1)
//            System.out.println("Floor of " + x + " doesn't exist in array");
//        else
//            System.out.println("Floor of " + x + " is " + arr[index]);
//    }
//}