import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q347TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<n; i++){
            // k = nums[i];
            if (map.containsKey(nums[i])){
                int v = map.get(nums[i]);
                map.put(nums[i], v+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] rt = new int[k];
        int i = 0;

        while(!heap.isEmpty()) {
            rt[i] = heap.poll();
            i++;
        }

        return rt;
    }
}
