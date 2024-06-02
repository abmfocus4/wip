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
//  https://www.youtube.com/watch?v=9VPm6nEbVPA&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=14&ab_channel=takeUforward
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        // interate ll and make last node point to head making circular ll
        // get len simultaneously
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        // cur is last node
        cur.next = head;

        k = k % len; // special case k (now k < len)
        k = len - k; // from front find node to point to head
        
        while (k-- > 0) cur = cur.next;

        // break list at node and set head
        head = cur.next;
        cur.next = null;

        return head;
    }
}