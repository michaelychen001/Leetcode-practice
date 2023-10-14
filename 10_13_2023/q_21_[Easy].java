/**
    Questions:
        You are given the heads of two sorted linked lists list1 and list2.
        Merge the two lists into one sorted list. The list should be made by
        splicing together the nodes of the first two lists.
        Return the head of the merged linked list.

    Example 1:
        Input: list1 = [1,2,4], list2 = [1,3,4]
        Output: [1,1,2,3,4,4]

    Example 2:
        Input: list1 = [], list2 = []
        Output: []

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public void print(ListNode pHead) {
        ListNode pp = pHead;
        System.out.print(pp.val);
        while(pp.next != null) {
            pp = pp.next;
            System.out.print(pp.val);
        }
        System.out.println();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p = null;
        ListNode pHead = null;

        if (p1 != null && p2 != null) {
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    if (p == null) {
                        p = p1;
                        pHead = p;
                    } else {
                        p.next = p1;
                        p = p.next;
                    }
                    p1 = p1.next;

                } else {
                    if (p == null) {
                        p = p2;
                        pHead = p;
                    } else {
                        p.next = p2;
                        p = p.next;
                    }
                    p2 = p2.next;
                }

                // print(pHead);
            }

            if (p1 != null) {
                p.next = p1;
            } else {
                p.next = p2;
            }
        } else {
            if (p1 == null) {
                pHead = p2;
            } else {
                pHead = p1;
            }
        }


        // print(pHead);

        return pHead;
    }
}