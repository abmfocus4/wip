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
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        int sum = 0, carry = 0;
        ListNode ans = new ListNode(0);
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
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