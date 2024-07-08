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

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Node cur = root;
        Node nxt = cur.left;

        while (cur != null && nxt != null) {
            if (cur.left != null) {
                cur.left.next = cur.right;
            }

            if (cur.right != null) {
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
            }

            cur = cur.next;
            if (cur == null) {
                cur = nxt;
                nxt = cur.left;
            }
        }

        return root;
    }
}