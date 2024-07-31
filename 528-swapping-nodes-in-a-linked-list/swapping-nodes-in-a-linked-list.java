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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        ListNode first = null;
        ListNode second = null;
        int counter = 0;

        while (cur != null) {
            counter++;
            if (second != null) {
                second = second.next;
            }
            if (counter == k) {
                first = cur;
                second = head;
            }
            cur = cur.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}