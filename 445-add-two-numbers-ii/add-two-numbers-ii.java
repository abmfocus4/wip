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
        Stack<Integer> stack = new Stack();
        int l1_len = 0, l2_len = 0;

        for (ListNode i = l1; i != null; i = i.next) l1_len++; // find len of both lists
        for (ListNode i = l2; i != null; i = i.next) l2_len++;

        int total = Math.max(l1_len, l2_len);

        for (ListNode i = l1, j = l2; total > 0; total--) { // total > 0
            // from top to bottom, just push one number for larger list and 
            // sum if both a and b are present in l1 and l2 positions
            int a = 0, b = 0;
            if (l1_len >= total) {
                a = i.val;
                i = i.next;
            }

            if (l2_len >= total) {
                b = j.val;
                j = j.next;
            }

            stack.push(a+b);
        }

        ListNode ans = new ListNode(0);
        int carry = 0;
        int sum = 0;

        while (stack.isEmpty() == false) { // same as before
            sum += stack.pop();
            ans.val = sum % 10; // ans is sum
            carry = sum / 10;
            ListNode newNode = new ListNode(carry); // new node is carry
            newNode.next = ans;
            ans = newNode;
            sum = carry;
        }

        if (carry == 0) {
            return ans.next;
        } else {
            return ans;
        }

    }
}