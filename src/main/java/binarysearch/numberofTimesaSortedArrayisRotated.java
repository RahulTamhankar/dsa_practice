package binarysearch;

public class numberofTimesaSortedArrayisRotated {
    // Returns count of rotations for an array
    // which is first sorted in ascending order,
    // then rotated
    static int countRotations(int arr[], int low, int high)
    {
        // This condition is needed to handle
        // the case when array is not rotated
        // at all
        if (high < low)
            return 0;

        // If there is only one element left
        if (high == low)
            return low;

        // Find mid
        // /*(low + high)/2;*/
        int mid = low + (high - low) / 2;

        // Check if element (mid+1) is minimum
        // element. Consider the cases like
        // {3, 4, 5, 1, 2}
        if (mid < high && arr[mid + 1] < arr[mid])
            return (mid + 1);

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return mid;

        // Decide whether we need to go to left
        // half or right half
        if (arr[high] > arr[mid])
            return countRotations(arr, low, mid - 1);

        return countRotations(arr, mid + 1, high);
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int arr[] = { 15, 18, 2, 3, 6, 12 };
        int N = arr.length;

        System.out.println(countRotations(arr, 0, N - 1));
    }
}

//minimum in sorted array
//int findMin(vector<int>& nums) {
//    int first = 0;
//    int n = nums.size();
//    int last = n - 1;
//    int middle = 0, prev = 0, next = 0;
//
//    while (first <= last) {
//        // Case where the subarray is already sorted
//        if (nums[first] <= nums[last]) {
//            return nums[first];
//        }
//
//        middle = first + (last - first) / 2;
//        prev = (middle - 1 + n) % n; // Circular index for previous element
//        next = (middle + 1) % n;     // Circular index for next element
//
//        // Check if middle is the minimum element
//        if (nums[middle] <= nums[next] && nums[middle] <= nums[prev]) {
//            return nums[middle];
//        }
//
//        // If the left half is sorted, the minimum is in the right half
//        if (nums[first] <= nums[middle]) {
//            first = middle + 1;
//        }
//        // If the right half is sorted, the minimum is in the left half
//        else {
//            last = middle - 1;
//        }
//    }
//
//    return -1; // Should never reach here
//}
