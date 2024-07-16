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
    public int kthSmallest(TreeNode root, int k) {
        return morris(root, k);
    }

    // Morris trav - https://www.youtube.com/watch?v=80Zug6D1_r4&t=1151s&ab_channel=takeUforward
    private int morris(TreeNode root, int k) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                if(--k == 0) return curr.val;
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    if(--k == 0) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}