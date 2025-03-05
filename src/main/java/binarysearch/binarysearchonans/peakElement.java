package binarysearch.binarysearchonans;

//STEPS-
//BS can be applied even to unsorted array

public class peakElement {
    // Function to find the peak element
    public static int findPeakElement(int[] arr) {
        int low = 0, high = arr.length - 1;

        // Edge cases for first and last elements
        if (arr.length == 1) return 0; // If the array has only one element, it is the peak

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is not the first or last element, and it's a peak element
            if (mid > 0 && mid < arr.length - 1) {  //// removed edge elements ie at n=0 and n=n1 [x.......y]. we will handle them seperately in elseif
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid; // Peak element found
                } else if (arr[mid - 1]>arr[mid]) { // go in the direction which is greater than mid

                    // If the left neighbor is greater, move left
                    high = mid - 1;
                } else {
                    // If the right neighbor is greater, move right
                    low = mid + 1;
                }
            }
            // Edge case when mid is at the start of the array (first element)
            else if (mid == 0) {
                if (arr[0] > arr[1]) {  //no need to check on left as there is nothing
                    return 0; // First element is the peak
                } else {
                    return 1; // Second element is the peak
                }
            }
            // Edge case when mid is at the last element (last element)
            else if (mid == arr.length - 1) {
                if (arr[arr.length - 1] > arr[arr.length - 2]) {
                    return arr.length - 1; // Last element is the peak
                } else {
                    return arr.length - 2; // Second last element is the peak
                }
            }
        }
        return -1; // Return -1 if no peak found, though this should not happen for valid input
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Test case: Peak element exists
        int[] arr1 = {1, 3, 20, 4, 1};
        int peakIndex1 = findPeakElement(arr1);
        System.out.println("Peak element index: " + peakIndex1 + " (Value: " + arr1[peakIndex1] + ")");

        // Test case: Peak element exists
        int[] arr2 = {1, 2, 3, 1};
        int peakIndex2 = findPeakElement(arr2);
        System.out.println("Peak element index: " + peakIndex2 + " (Value: " + arr2[peakIndex2] + ")");
    }
}
