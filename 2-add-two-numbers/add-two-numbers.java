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
        // iterate through both ll until both are empty
        // propagate sum in new ll and carry in sum
        // end check if sum is 0, otherwise create last node
        ListNode dummy = new ListNode(-1); // will stay at head
        ListNode ans = dummy; // will move forward
        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            ans.next = new ListNode(sum % 10); // last digit
            carry = sum / 10; // rest of the digits
            sum = carry;
            ans = ans.next;
        }

        if (sum != 0) {
            ans.next = new ListNode(sum);
        }

        return dummy.next;
    }
}