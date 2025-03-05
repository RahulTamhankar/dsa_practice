package binarysearch;



//This Question = firstOccurance + InfiniteSortedArray

public class indexofFirst1inaBinarySortedInfiniteArray  {
    // Function to find the position of first 1 in an infinite sorted array
    public static int findPosition(int[] arr, int k) {
        // Step 1: Find the bounds (start and end)
        int start = 0;
        int end = 1;

        // Keep doubling the `end` index until arr[end] is greater than or equal to 1
        while (arr[end] < k) {
            start = end;
            end = end * 2; // Double the `end` index
        }

        System.out.println("Bounds found: Start = " + start + ", End = " + end);

        // Step 2: Apply binary search on the range [start, end]
        return binarySearch(arr, start, end, k);
    }

    // Binary search method to find the first occurrence of k in the given range [start, end]
    private static int binarySearch(int[] arr, int start, int end, int k) {
        int res = -1; // Default if the element is not found

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < k) {
                start = mid + 1; // Move right if current element is less than k
            } else if (arr[mid] > k) {
                end = mid - 1; // Move left if current element is greater than k
            } else {
                res = mid; // Element found
                end = mid - 1; // Continue searching in the left half to find the first occurrence of k
            }
        }

        return res; // Return the index of the first 1 found
    }

    public static void main(String[] args) {
        // Example infinite sorted array (for simulation, we use a finite array)
        int[] arr = {0, 0, 1, 1, 1, 1}; // Example finite representation of an infinite array

        int k = 1; // We are searching for the first occurrence of 1
        int result = findPosition(arr, k);

        // Output the result
        if (result != -1) {
            System.out.println("First occurrence of 1 found at index: " + result);
        } else {
            System.out.println("1 not found.");
        }
    }
}
