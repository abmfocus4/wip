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
    int maxPathSumWithSplitting = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumWithoutSplitting(root);
        return maxPathSumWithSplitting;
    }

    private int maxPathSumWithoutSplitting(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(maxPathSumWithoutSplitting(root.left), 0);
        int rightMax = Math.max(maxPathSumWithoutSplitting(root.right), 0);
        maxPathSumWithSplitting = Math.max(maxPathSumWithSplitting, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}