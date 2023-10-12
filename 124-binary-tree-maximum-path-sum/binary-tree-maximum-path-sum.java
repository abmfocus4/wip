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

 // Reference: https://www.youtube.com/watch?v=mOdetMWwtoI
 // Look at example in video and comments for more info
class Solution {
    int bestMaxSum;
    public int maxPathSum(TreeNode root) {
        bestMaxSum = Integer.MIN_VALUE;
        maxSum(root); // updates bestMaxSum
        return bestMaxSum;
    }

    private int maxSum(TreeNode root) {
        if (root == null) return 0;
        // best left subtree sum
        int left = Math.max(maxSum(root.left), 0); // you cannot make existing value bigger by adding negative value so discard negative value by using 0
        // best right subtree sum
        int right = Math.max(0, maxSum(root.right)); // same as above

        // either start new path (root+left+right) or continue old path
        bestMaxSum = Math.max(bestMaxSum, root.val + left + right);

        return root.val + Math.max(left, right); // just returning root and best of left or right subtree sum
    }
}