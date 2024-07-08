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
            return null;
        }
        Queue<Node> q = new LinkedList();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }

                if (i == levelSize - 1) {
                    cur.next = null;
                } else {
                    cur.next = q.peek();
                }
             }
        }

        return root;
    }
}