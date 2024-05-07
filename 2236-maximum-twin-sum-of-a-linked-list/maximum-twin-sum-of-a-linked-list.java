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
    public int pairSum(ListNode head) {
        // split middle
        // reverse list
        ListNode head2 = split(head);
        head2 = reverse(head2);

        //find pair sum max
        int max = 0;
        while (head != null && head2 != null) {

            max = Math.max(head.val + head2.val, max);
            head = head.next;
            head2 = head2.next;
        }
        return max;
    }

    private ListNode split(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = head; // even case, start late, (both odd and even start early)
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;

        return head2;
    }

    private ListNode reverse (ListNode head) {
        ListNode curr = head; // DON'T WANT TO CHANGE ACTUAL head linkedlist
        ListNode prevNode = null;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        return prevNode;
    }
}