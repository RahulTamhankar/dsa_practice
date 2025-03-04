package binarysearch;

public class ceilofAnElementInaSortedArray {


    // Method to find the ceil of an element in a sorted array
    public static int ceilOfElement(int[] arr, int key) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int res = -1;  // Initialize res to -1, which will hold the ceil value

        while (start <= end) {  // Use <= to check all elements
            int mid = (start + end) / 2;

            // If the element at mid is the key, return the key
            if (arr[mid] == key) {
                return arr[mid];
            }

            // If the mid element is greater than the key, it might be the ceil
            if (arr[mid] > key) {
                res = arr[mid];  // Update res to the current element
                end = mid - 1;  // Look for a smaller element
            }
            // If the mid element is smaller than the key, move to the right half
            else {
                start = mid + 1;
            }
        }

        return res;  // Return the ceil, or -1 if no ceil exists
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int key = 5;

        int result = ceilOfElement(arr, key);
        if (result == -1) {
            System.out.println("No ceil exists for " + key);
        } else {
            System.out.println("Ceil of " + key + " is " + result);
        }

        // Another example
        key = 20;
        result = ceilOfElement(arr, key);
        if (result == -1) {
            System.out.println("No ceil exists for " + key);
        } else {
            System.out.println("Ceil of " + key + " is " + result);
        }
    }
}
