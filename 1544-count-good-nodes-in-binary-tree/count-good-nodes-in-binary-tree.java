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
    int totalGoodNodes;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        totalGoodNodes = 0;
        calculateGoodNodes(root, root.val); // keep track of max value seen so far
        return totalGoodNodes;
    }
    
    public void calculateGoodNodes(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            totalGoodNodes++;
            max = root.val;
        }
        calculateGoodNodes(root.left, max);
        calculateGoodNodes(root.right, max);
    }
}