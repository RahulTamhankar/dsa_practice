package recursion;

import java.util.Arrays;

public class sortAnArrayUsingRecursion {

    private static void sort(int[] arr, int n) {
        if (n == 1) return; // Base case: Single element is already sorted

        // Store last element and reduce array size
        int temp = arr[n - 1];
        sort(arr, n - 1);

        // Insert temp at the correct position
        insert(arr, n - 1, temp);
    }

    private static void insert(int[] arr, int n, int key) {
        if (n == 0 || arr[n - 1] <= key) {
            arr[n] = key; // Place key in the correct position
            return;
        }

        int val = arr[n - 1]; // Store last element
        insert(arr, n - 1, key); // Recursive call
        arr[n] = val; // Restore last element
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 5, 2};
        sort(arr, arr.length);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
