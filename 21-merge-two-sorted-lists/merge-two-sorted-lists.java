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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy_head = new ListNode(0);
        ListNode curNode = dummy_head;   
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }

        if (list1 != null) {
            curNode.next = list1;
            // list1 = list1.next;
        }

        if (list2 != null) {
            curNode.next = list2;
            // list2 = list2.next;
        }

        return dummy_head.next;
    }
}