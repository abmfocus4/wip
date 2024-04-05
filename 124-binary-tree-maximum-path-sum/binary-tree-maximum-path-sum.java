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
    int bestPathSum;
    public int maxPathSum(TreeNode root) { // path sum with splitting
        bestPathSum = Integer.MIN_VALUE;
        pathSumWithoutSplitting(root); // maxPathSum when we split at root
        return bestPathSum;
    }

    public int pathSumWithoutSplitting(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(pathSumWithoutSplitting(root.left), 0);
        int rightMax = Math.max(pathSumWithoutSplitting(root.right), 0);

        bestPathSum = Math.max(bestPathSum, root.val + leftMax + rightMax);

        // max of 0, left and right (all 3 values)
        return root.val + Math.max(leftMax, rightMax); // splitting, assume we already split at the root
    } 
}