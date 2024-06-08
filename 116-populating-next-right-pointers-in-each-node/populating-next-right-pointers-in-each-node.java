/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

// bfs solution
// https://www.youtube.com/watch?v=U4hFQCa1Cq0&ab_channel=NeetCode
class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node cur = root;
        Node nxt = root.left;

        while (cur != null && nxt != null) {
            cur.left.next = cur.right;
            if (cur.next != null) {
                cur.right.next = cur.next.left;
            }
            cur = cur.next; // moving in the same level
            if (cur == null) { // if we finished traversing level
                cur = nxt;
                nxt = cur.left; // point to next level
            }
        }

        return root;
    }
}

// TC: o(n), SC:O(1)