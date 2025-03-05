package binarysearch;

public class findPositionOfAnElementinAnInfiniteSortedArray {
    // Method to find the position of k in an infinite sorted array
    public static int findPosition(int[] arr, int k) {
        // Step 1: Find the bounds (start and end)
        int start = 0;
        int end = 1;

        // Keep doubling the `end` index until arr[end] is greater than k
        while (arr[end] <= k) {
            start = end;
            end = end * 2; // Double the `end` index
        }

        System.out.println("Bounds found: Start = " + start + ", End = " + end);

        // Step 2: Apply binary search on the range [start, end]
        return binarySearch(arr, start, end, k);
    }

    // Binary search method to find k in the given range [start, end]
    private static int binarySearch(int[] arr, int start, int end, int k) {
        int resultIndex = -1;  // Default if the element is not found
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < k) {
                start = mid + 1;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                resultIndex = mid;  // Element found
                break;
            }
        }
        return resultIndex;
    }

    public static void main(String[] args) {
        // Example infinite sorted array (Note: For simulation, we use a finite array)
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};

        int k = 7;  // Element to search for
        int result = findPosition(arr, k);

        // Output the result
        if (result != -1) {
            System.out.println("Element " + k + " found at index: " + result);
        } else {
            System.out.println("Element " + k + " not found.");
        }
    }
}