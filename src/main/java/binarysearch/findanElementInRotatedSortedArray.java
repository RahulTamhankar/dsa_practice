package binarysearch;

public class findanElementInRotatedSortedArray {
    // Method to perform binary search in a rotated sorted array
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the target is found, return the index
            if (nums[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if target lies in the left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // If the right half is sorted
                // Check if target lies in the right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1; // Return -1 if target is not found
    }

    // Main method to test the search functionality
    public static void main(String[] args) {
        // Test Case 1: Array rotated and target exists
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        System.out.println("Index of " + target1 + ": " + search(nums1, target1)); // Expected: 4

        // Test Case 2: Array rotated and target does not exist
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        System.out.println("Index of " + target2 + ": " + search(nums2, target2)); // Expected: -1

        // Test Case 3: Array not rotated and target exists
        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 4;
        System.out.println("Index of " + target3 + ": " + search(nums3, target3)); // Expected: 3

        // Test Case 4: Array not rotated and target does not exist
        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 6;
        System.out.println("Index of " + target4 + ": " + search(nums4, target4)); // Expected: -1
    }
}
