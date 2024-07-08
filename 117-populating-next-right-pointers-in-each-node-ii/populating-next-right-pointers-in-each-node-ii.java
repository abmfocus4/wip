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
// https://www.youtube.com/watch?v=BcQXUsd-f1k&ab_channel=EricProgramming
class Solution {
    public Node connect(Node root) {
        Node cur = root;

        while (cur != null) {
            Node nxtHead = new Node(-1);
            Node nxt = nxtHead;
            // building linkedlist with nxtHead pointing to cur
            while (cur != null) {
                if (cur.left != null) {
                    nxt.next = cur.left;
                    nxt = nxt.next;
                }

                if (cur.right != null) {
                    nxt.next = cur.right;
                    nxt = nxt.next;
                }

                cur = cur.next;
            }

            // move to next level
            cur = nxtHead.next;
        }

        return root;

    }
}