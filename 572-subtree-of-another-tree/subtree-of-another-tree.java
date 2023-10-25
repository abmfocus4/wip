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

 // Recursive
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if node is null return false
        // check if root matches the subRoot, if yes, return true
        // else check if root's left matches subRoot or root's right matches subRoot

        // if root is null and subroot is null return true
        // if root is null or subroot is null return false
        // if value of root is not same, then return false
        // else compare left nodes and right nodes of each tree respectively

        if (root == null) return false; // to make sure that when we access left and right of root we don't get error
        if (isSameTree(root, subRoot)) return true;
        else return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
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