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
 // Ref: https://leetcode.com/problems/invert-binary-tree/solutions/2463600/easy-100-fully-explained-java-c-python-js-c-python3-recursive-iterative/?envType=list&envId=pxw54vnt

// Recursive
class Solution {
// Time Complexity : O(n)
// Space Complexity : O(n)
    public TreeNode invertTree(TreeNode root) {
        // base case
        if (root == null) return root;

        // recurse over lef
        invertTree(root.left);
        // recurve over right
        invertTree(root.right);

        // swap left and right
        TreeNode tmp_left = root.left;
        root.left = root.right;
        root.right = tmp_left;

        return root;
    }
}