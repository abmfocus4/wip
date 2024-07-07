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
    public ListNode partition(ListNode head, int x) {
        ListNode lesserLL = new ListNode(0);
        ListNode greaterLL = new ListNode(0);

        ListNode lesserHead = lesserLL;
        ListNode greaterHead = greaterLL;

        while (head != null) {
            if (head.val < x) {
                lesserLL.next = head;
                lesserLL = lesserLL.next;
            } else {
                greaterLL.next = head;
                greaterLL = greaterLL.next;
            }
            head = head.next;
        }

        lesserLL.next = greaterHead.next;
        greaterLL.next = null;

        return lesserHead.next;
    }
}