package binarysearch.binarysearchonans;


//similar to rotated sorted array. In this question there can be multiple peaks but in rotated sorted only 1 peak
public class searchAnElementinBitonicArray {

    // Function to find the peak element index
    public static int findPeakElement(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if mid is the peak element
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid; // Peak found
                } else if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1; // Move right
                } else {
                    high = mid - 1; // Move left
                }
            }
            // Edge case: Check if first element is the peak
            else if (mid == 0) {
                if (arr[0] > arr[1]) {
                    return 0;
                } else {
                    return 1;
                }
            }
            // Edge case: Check if last element is the peak
            else if (mid == arr.length - 1) {
                if (arr[arr.length - 1] > arr[arr.length - 2]) {
                    return arr.length - 1;
                } else {
                    return arr.length - 2;
                }
            }
        }
        return -1; // No peak found (which should not happen for valid input)
    }

    // Binary search in increasing order
    public static int binarySearchIncreasing(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid; // Key found
            } else if (arr[mid] < key) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Key not found
    }

    // Binary search in decreasing order
    public static int binarySearchDecreasing(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid; // Key found
            } else if (arr[mid] > key) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return -1; // Key not found
    }

    // Main function to solve the problem
    public static int searchInBitonicArray(int[] arr, int key) {
        int peakIndex = findPeakElement(arr);

        // First, search in the increasing part
        int result1 = binarySearchIncreasing(arr, key, 0, peakIndex);
        // Then, search in the decreasing part
        int result2 = binarySearchDecreasing(arr, key, peakIndex, arr.length - 1);

        // If found in either, return the index
        if (result1 != -1) {
            return result1;
        }
        if (result2 != -1) {
            return result2;
        }

        // If not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {-3, 9, 8, 20, 17, 5, 1};
        int key = 20;

        // Function call
        int result = searchInBitonicArray(arr, key);
        System.out.println("Element " + key + " is found at index: " + result); // Expected output: 3
    }
}
