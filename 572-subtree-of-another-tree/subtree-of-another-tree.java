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

 // https://leetcode.com/problems/subtree-of-another-tree/solutions/102724/java-solution-tree-traversal/comments/106046

 // Tree traversal

 // Time: O(m*m)

 // Space: O(height of first tree) == O(m) worst case and O(logm) balanced tree case
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // take queue- add root to queue
        // for each node in root = check if is same subtree
        // add left and right to queue if not null
        // repeat until queue is empty

        // if root is null and subroot is null return true
        // if root is null or subroot is null return false
        // if value of root is not same, then return false
        // else compare left nodes and right nodes of each tree respectively

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (q.isEmpty() != true) {
            TreeNode node = q.poll();
            if (isSameTree(node, subRoot)) return true;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return false;
    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) return true;
        if (node == null || subRoot == null) return false;
        if (node.val != subRoot.val) return false;
        else {
            return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
        }
    }
}