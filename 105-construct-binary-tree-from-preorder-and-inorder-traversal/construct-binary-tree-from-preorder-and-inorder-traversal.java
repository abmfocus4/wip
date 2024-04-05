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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // use helper function to return node of tree
        // use preorder arr for finding root
        // inorder arr for finding left and right subtree
        // leaf nodes for null can be found if boundary checks

        return helper(0, 0, inorder.length - 1, preorder, inorder);
        
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null; //leaf nodes
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inRootIndex = i;
                break;
            }
        }

        int numLeftNodes = inRootIndex - inStart;

        root.left = helper(preStart + 1, inStart, inRootIndex - 1, preorder, inorder);
        root.right = helper(preStart + 1 + numLeftNodes, inRootIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}