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
    int maxPath;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        this.maxPath = 0;
        dfs(root, root.val);
        return maxPath;
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        maxPath = Math.max(maxPath, left + right);
        return  prev == root.val ? 1 + Math.max(left, right) : 0;
    }
}