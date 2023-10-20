/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // Ref: https://leetcode.com/problems/linked-list-cycle/solutions/44694/accepted-clean-java-solution/
 // Explanation: https://leetcode.com/problems/linked-list-cycle/solutions/44694/accepted-clean-java-solution/comments/1032829
 // base case: https://leetcode.com/problems/linked-list-cycle/solutions/44694/accepted-clean-java-solution/comments/1299185
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false; // edge case

        ListNode slow = head, fast = head; // two pointer, tortoise & hare approach

        while (fast != null && fast.next != null) { // if the fast node reaches end
            slow = slow.next; // moves one time each loop
            fast = fast.next.next; // moves two times each loop

            if (fast == slow) return true; // if slow catches upto fast eventually if it has cycle
        }
        return false;
    }
}