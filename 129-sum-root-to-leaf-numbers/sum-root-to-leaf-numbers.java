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

 // Ref: https://leetcode.com/problems/sum-root-to-leaf-numbers/solutions/41531/clean-java-dfs-solution-preorder-traversal/comments/39706

 // Exp: https://leetcode.com/problems/sum-root-to-leaf-numbers/solutions/3297915/explained-with-images-think-and-code-like-a-pro-beats-100/
 
class Solution {
    public int sumNumbers(TreeNode root) {
        return DFS(root, 0);
    }

    private int DFS(TreeNode node, int sum) { // backtrack
        if (node == null) return 0;
        int newSum = 10*sum + node.val;
        if (node.left == null && node.right == null) return newSum; // leaf node is reached
        return DFS(node.left, newSum) + DFS(node.right, newSum);
    }
}