/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 * */

//public class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class Q876MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            System.out.println(String.valueOf(p1.val) + ", " + String.valueOf(p2.val));
        }

        if (p2.next != null) {
            p1 = p1.next;
        }

        return p1;
    }

    public static void main(String[] args) {

    }

}