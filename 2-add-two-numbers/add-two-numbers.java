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
//  https://www.youtube.com/watch?v=B-uQN5wp6Jg&ab_channel=codestorywithMIK
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0, carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            sum = carry;
            ans.next = newNode;
            ans = ans.next;
        }

        if (sum > 0) {
            ans.next = new ListNode(sum);
        }

        return dummy.next;
    }
}