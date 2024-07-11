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
//  https://leetcode.com/problems/recover-binary-search-tree/solutions/32535/no-fancy-algorithm-just-simple-and-powerful-in-order-traversal
class Solution {
    TreeNode firstNode;
    TreeNode secondNode;
    TreeNode prevNode;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (firstNode == null && prevNode != null && prevNode.val > root.val) {
            firstNode = prevNode;
        }

        if (firstNode != null && prevNode != null && prevNode.val > root.val) {
            secondNode = root;
        }

        prevNode = root;
        inorder(root.right);
    }
}