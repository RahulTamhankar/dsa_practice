import java.time.chrono.MinguoChronology;
import java.util.Arrays;
import java.util.Scanner;

public class cp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        int n = sc.nextInt();  // Number of elements in the array
        int[] arr = new int[n]; // Array to hold the elements
        int min=Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if(arr[i]==0){
                System.out.println(0);
                return;
            }else {
                min= Math.min(min,Math.abs(arr[i]));
            }
        }
        System.out.println(min);
        sc.close();
    }
}