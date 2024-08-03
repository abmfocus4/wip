/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair {
        TreeNode node;
        int id;
        Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        // assign index to each node
        // left: 2x
        // right: 2x + 1
        // root : x = 1

        // dq: at each level diff of last and first element and max of each level


        Deque<Pair> dq = new LinkedList();
        if (root == null) return 0;
        dq.add(new Pair(root, 1));

        int maxWidth = 1;

        while (dq.isEmpty() == false) {
            int levelSize = dq.size();
            maxWidth = Math.max(maxWidth, Math.abs(dq.peekFirst().id - dq.peekLast().id) + 1);
            while (levelSize-- > 0) {
                Pair cur = dq.poll();
                TreeNode curNode = cur.node;
                int idx = cur.id;
                if (cur.node.left != null) {
                    dq.add(new Pair(cur.node.left, cur.id * 2));
                }
                if (cur.node.right != null) {
                    dq.add(new Pair(cur.node.right, cur.id * 2 + 1));
                }
            }
        }

        return maxWidth;

    }
}