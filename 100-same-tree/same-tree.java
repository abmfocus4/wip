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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // use queue to sequentially compare corresponding nodes in each subtree
        // first add the roots of the trees
        // while the queue is not empty
        // complete equality checks
        // add left and right nodes to queue
        // return true once the loop is exited

        Queue<TreeNode> queue = new LinkedList();
        queue.add(p);
        queue.add(q);
        while(!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if (a == null && b == null) continue;
            else if (a == null || b == null || a.val != b.val) return false;
            queue.add(a.left);
            queue.add(b.left);
            queue.add(a.right);
            queue.add(b.right);
        }

        return true;
    }
}