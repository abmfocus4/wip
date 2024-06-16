/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// https://www.youtube.com/watch?v=sWf7k1x9XR4&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=19&ab_channel=takeUforward
class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode prev = cur.left;
                while (prev.right != null) { // find right most node
                    prev = prev.right;
                }
                prev.right = cur.right; // threaded binary tree // figure out where the right most left subtree node should point

                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}