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
        Node head = root;

        while (head != null) {
            Node dummy = new Node(-1);
            Node tmp = dummy;
            // building linkedlist with dummy pointing to head
            while (head != null) {
                if (head.left != null) {
                    tmp.next = head.left;
                    tmp = tmp.next;
                }

                if (head.right != null) {
                    tmp.next = head.right;
                    tmp = tmp.next;
                }

                head = head.next;
            }

            // move to next level
            head = dummy.next;
        }

        return root;

    }
}