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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                prev = cur;
            } else {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next; // get to the last node in the duplicate sequence
                }
                // have prev next point to next node of the (last node in duplicate sequence)
                if (prev == null) {
                    head = cur.next;
                } else {
                    prev.next = cur.next;
                }
            }
            cur = cur.next;
        }

        return head;
    }
}