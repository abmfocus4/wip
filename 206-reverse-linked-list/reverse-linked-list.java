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

// Explanation: https://leetcode.com/problems/reverse-linked-list/solutions/2682085/java-0ms-100-easy-understanding/
// https://leetcode.com/problems/reverse-linked-list/solutions/803955/c-iterative-vs-recursive-solutions-compared-and-explained-99-time-85-space/

// Sol: https://leetcode.com/problems/reverse-linked-list/solutions/58125/in-place-iterative-and-recursive-java-solution/
// https://leetcode.com/problems/reverse-linked-list/solutions/58125/in-place-iterative-and-recursive-java-solution/comments/59714

// pointer solution - iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prevHead;
            prevHead = head;
            head = nextNode;
        }
        return prevHead;
    }
}