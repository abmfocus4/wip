// https://www.youtube.com/watch?v=B-uQN5wp6Jg&ab_channel=codestorywithMIK
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
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        
        while (l1 != null) { // push all l1 elements into stack
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0, carry = 0;
        ListNode ans = new ListNode(0);
        while (s1.isEmpty() == false || s2.isEmpty() == false) {
            if (s1.isEmpty() == false) {
                sum += s1.pop();
            }

            if (s2.isEmpty() == false) {
                sum += s2.pop();
            }
            ans.val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(carry);
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

    // private void PrintAns(ListNode head) {
    //     while (head != null) {
    //         System.out.println(head.val);
    //         head = head.next;
    //     }

    //     System.out.println("-----");
    // }
}