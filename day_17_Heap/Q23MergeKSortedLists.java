import java.util.PriorityQueue;

public class Q23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        // define a heap with Comparator
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // create the heap
        for(ListNode list: lists){
            if (list != null) {
                heap.offer(list);
            }
        }

        // Do traversing
        // while(heap.size() > 0){
        //     System.out.println(heap.peek().val);
        //     heap.poll();
        // }

        // define the ret_val
        ListNode res = new ListNode(0);
        ListNode cur = res;

        // sorting
        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            cur.next= top;
            cur = cur.next;
            if (top.next != null) {
                heap.offer(top.next);
            }
        }

        return res.next;
    }
}
