import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Q138CopyListWithRandom {
    public Node copyRandomList(Node head) {
        /*
        * Time: O(2n)
        * Space: O(n) -> HashMap
        */
        Map<Node, Node> map = new HashMap<Node, Node>();

        Node p1 = head;
        Node copyHead = new Node(-1);
        Node prevCopy = null;
        while(p1!=null){
            // define a new node
            Node copy = new Node(p1.val);
            if (copyHead.next == null){
                // if the 1st round, set copyHead's next is the curr copy
                copyHead.next = copy;
            }
            // put the mapping into map
            map.put(p1, copy);
            // System.out.print(p1);
            // System.out.print(copy);
            // System.out.println("----------------");
            // update p1
            p1 = p1.next;
            // save copy as ref
            if (prevCopy != null) {
                prevCopy.next = copy;
            }
            prevCopy = copy;
        }

        System.out.println("=======================");
        p1 = head;
        Node p2 = copyHead.next;
        while(p1!=null){
            // traverse p1
            // if (p1.random != null){
            //     p2.random = map.get(p1.random);
            // }
            // System.out.print(p1.random);
            if (p1.random != null){
                p2.random = map.get(p1.random);
                // System.out.print(map.get(p1.random));
            }
            // System.out.println("----------------");
            p1 = p1.next;
            p2 = p2.next;
        }
        return copyHead.next;
    }
}
