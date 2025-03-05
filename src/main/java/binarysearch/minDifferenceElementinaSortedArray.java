package binarysearch;




//### The main concept here is if the key is not found
//in the end, low and high will come to end
//ie. low will come to 2nd last and high will come to last
//and in between these 2nd last and last there will be abstract key which will
//be present
//-----------
//Eg.1 3 8 10 15 and key is 12
//so in the end low will be 10 and high will be 15
//and key=12 will be present in between.. But the while loop will not end
// in last iteration mid=(4+4)/2=4 hence low=mid=high=4
//hence it will go to else if and high will become mid-1
//and low and mid will be at n-1 ie the last element

public class minDifferenceElementinaSortedArray {
    // Function to find the element with minimum difference to the given key
    public static int minDiffElement(int[] arr, int key) {
        int n = arr.length;

        int low = 0, high = n - 1;
        int minDiff = Integer.MAX_VALUE;
        int ans = -1;

        // Binary search approach using your logic
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate mid properly

            int diff = Math.abs(arr[mid] - key);

            // Update the minimum difference and answer if the current difference is smaller
            if (diff < minDiff) {
                minDiff = diff;
                ans = arr[mid];
            }

            // If the current element is equal to key, return the key
            if (arr[mid] == key) {
                return key;
            }
            // If the key is smaller than the middle element, search in the left half
            else if (key< arr[mid]) {
                high = mid - 1;
            }
            // If the key is greater than the middle element, search in the right half
            else {
                low = mid + 1;
            }
        }

        // Return the element with the minimum difference
        return ans;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 15};
        int key = 12;

        // Function call to find the element with minimum difference
        int result = minDiffElement(arr, key);

        // Output the result
        System.out.println("Element with minimum difference to " + key + " is: " + result);
    }
}
