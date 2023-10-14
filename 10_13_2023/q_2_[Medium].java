/**
    Questions:
        You are given two non-empty linked lists representing two non-negative integers. The digits are stored
        in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the
        sum as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.

    Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]

    Example 3:
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean addFlag = false;

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode pNew = null;
        ListNode pNewHead = null;


        while (p1 != null && p2 != null) {
            int val1 = p1.val;
            int val2 = p2.val;
            int sum = val1 + val2;

            if (addFlag) {
                sum++;
                addFlag = false;
            }

            if (sum >= 10) {
                addFlag = true;
                sum = sum-10;
            }

            if (pNew == null) {
                pNew = new ListNode(sum);
                pNewHead = pNew;
            } else {
                ListNode tmp = new ListNode(sum);
                pNew.next = tmp;
                pNew = pNew.next;
            }

            if (p1.next != null && p2.next != null){
                    p1 = p1.next;
                    p2 = p2.next;
            } else {
                break;
            }
        }

        ListNode p;
        if (p1.next != null) {
            p = p1;
        } else {
            p = p2;
        }

        while(p.next != null) {
            p = p.next;
            int sum = p.val;

            if (addFlag) {
                sum++;
                addFlag = false;
            }

            if (sum >= 10) {
                addFlag = true;
                sum = sum-10;
            }

            if (pNew == null) {
                pNew = new ListNode(sum);
                pNewHead = pNew;
            } else {
                ListNode tmp = new ListNode(sum);
                pNew.next = tmp;
                pNew = pNew.next;
            }

        }

        if (addFlag) {
            ListNode tmp = new ListNode(1);
            pNew.next = tmp;
        }

        return pNewHead;
    }
}