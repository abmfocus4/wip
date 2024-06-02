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
//  https://www.youtube.com/watch?v=bRZ_Fy4zRRY&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=10&ab_channel=codestorywithMIK
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy; // if left is head then prev is dummy
        for (int i = 1; i < left; i++) { // set prev node
            prev = prev.next;
        }

        ListNode cur = prev.next;
        for (int i = 1; i <= (right - left); i++) {
            ListNode temp = prev.next;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = temp;
        }

        return dummy.next;
    }
}