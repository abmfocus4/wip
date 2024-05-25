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
//  https://www.youtube.com/watch?v=2XTXL7a6ItI&ab_channel=codestorywithMIK
// Time: (logn)^2
// at each node, log n traversal to find height
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);

        if (lh == rh) {
            return (1 << lh) - 1; 
            // 2 pow h - 1 is the number of nodes in complete bst
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeftHeight(TreeNode root) {
        TreeNode temp = root;
        int lh = 0;

        while (temp != null) {
            temp = temp.left;
            lh++;
        }

        return lh;
    }

    private int getRightHeight(TreeNode root) {
        TreeNode temp = root;
        int rh = 0;

        while (temp != null) {
            temp = temp.right;
            rh++;
        }
        return rh;
    }
}