package heap;
import java.util.*;
//
//
//public class frequenceySort {
//
//    public static List<Integer> frequencySort(int[] nums) {
//        // Step 1: Create a frequency map (HashMap)
//        Map<Integer, Integer> frequencyMap = new HashMap<>();
//        for (int num : nums) {
//            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
//        }
//
//        // Step 2: Create a max heap (PriorityQueue) to store elements by frequency
//        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
//                (a, b) -> b.getValue() - a.getValue()  // Sort by frequency in descending order
//        );
//
//        // Add all the entries from the frequency map into the max heap
//        maxHeap.addAll(frequencyMap.entrySet());
//
//        // Step 3: Build the result list based on the max heap
//        List<Integer> result = new ArrayList<>();
//        while (!maxHeap.isEmpty()) {
//            Map.Entry<Integer, Integer> entry = maxHeap.poll();
//            int frequency = entry.getValue();
//            int element = entry.getKey();
//
//            // Add the element 'frequency' number of times to the result
//            for (int i = 0; i < frequency; i++) {
//                result.add(element);
//            }
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        // Example usage
//        int[] nums = {2, 5, 2, 8, 5, 6, 8, 8};
//
//        // Print the result from frequencySort
//        List<Integer> sortedList = frequencySort(nums);
//        System.out.println(sortedList);  // Expected Output: [8, 8, 8, 2, 2, 5, 5, 6]
//    }
//}


//Above gives output as [8, 8, 8, 5, 5, 2, 2, 6] hence for same freq it does not maintain the order
public class frequenceySort {


    public static List<Integer> frequencySort(int[] nums) {
        // Step 1: Create a frequency map (HashMap)
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: We need to store elements in a way that maintains their order of appearance
        // when frequencies are the same, so we use a List of entries sorted by frequency
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list based on frequency, and in case of ties, maintain the order of appearance
        list.sort((a, b) -> {
            if (a.getValue() == b.getValue()) {
                // If frequencies are the same, we maintain the order of appearance
                return 0;
            } else {
                return b.getValue() - a.getValue(); // Sort by frequency in descending order
            }
        });

        // Step 3: Build the result list based on sorted entries
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            int frequency = entry.getValue();
            int element = entry.getKey();
            for (int i = 0; i < frequency; i++) {
                result.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {2, 5, 2, 8, 5, 6, 8, 8};

        // Print the result from frequencySort
        List<Integer> sortedList = frequencySort(nums);
        System.out.println(sortedList);  // Expected Output: [8, 8, 8, 2, 2, 5, 5, 6]
    }
}
