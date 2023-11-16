import java.util.PriorityQueue;

public class Q215KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int x: nums){
            if (heap.size() < k || x >= heap.peek()){
                // peek(): Returns the highest-priority element without removing it from the queue.
                heap.add(x); // heap.offer(x);
            }
            if (heap.size() > k) {
                heap.poll(); // poll(): Removes and returns the highest-priority element in the queue.
            }
        }
        return heap.peek();
    }
}
