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
    public int sumNumbers(TreeNode root) {
        // tree traversal
        // update running sum
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int runningSum) {
        if (root == null) return 0;
        runningSum = 10*runningSum + root.val;
        if (root.left == null && root.right == null) return runningSum;
        return dfs(root.left, runningSum) + dfs(root.right, runningSum);
    }
}