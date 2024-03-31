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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node == null) continue;
            pq.add(node);
        }

        ListNode dummy_node = new ListNode(0);
        ListNode cur_node = dummy_node;

        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            cur_node.next = top;
            if (top.next != null) pq.add(top.next);
            cur_node = cur_node.next;
        }

        return dummy_node.next;
    }
}