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
//  https://leetcode.com/problems/merge-k-sorted-lists/solutions/10522/my-simple-java-solution-use-recursion
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode head = merge(lists, 0, lists.length - 1);
        return head;
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left)/2;
        ListNode list1 = merge(lists, left, mid);
        ListNode list2 = merge(lists, mid+1, right);
        return sort(list1, list2);
    }

    public ListNode sort(ListNode list1, ListNode list2) {
        ListNode dummy_node = new ListNode(0);
        ListNode curNode = dummy_node;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
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
        }

        if (list2 != null) {
            curNode.next = list2;
        }
        return dummy_node.next;
    }
}