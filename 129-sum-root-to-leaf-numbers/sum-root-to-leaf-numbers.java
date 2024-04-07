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
        return DFS(root, 0);
    }

    public int DFS(TreeNode root, int sum) {
        if (root == null) return 0;
        int runningSum = sum*10 + root.val;
        if (root.left == null && root.right == null) return runningSum; 
        return DFS(root.left, runningSum) + DFS(root.right, runningSum);
    }
}