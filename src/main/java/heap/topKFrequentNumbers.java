package heap;

import java.util.*;

public class topKFrequentNumbers {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Step 1: Count the frequency of each element
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a priority queue to maintain the top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue() // Min-heap based on frequency
        );

        // Step 3: Add all map entries to the min-heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);

            // Ensure the heap does not grow beyond size k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 4: Extract the elements from the heap into the result list
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        // Since we need the result in descending frequency order, reverse the list
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {

        // Example usage
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> topK = topKFrequent(nums, k);

        System.out.println(topK); // Output: [1, 2]
    }
}
