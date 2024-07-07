/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        TreeNode p = root.left;
        TreeNode q = root.right;
        
        while (p != null && q != null) {
            if (p.val != q.val) return false;

            // do tree p inorder traversal
            if (p.left != null){
                TreeNode prev = p.left;
                while (prev.right != p && prev.right != null)
                {
                    prev = prev.right;
                }
                if (prev.right == null){
                    prev.right = p;
                    p = p.left;
                }
                else {
                    prev.right = null;
                    p = p.right;
                }
            } else {
                p = p.right;
            }
            
            // do q inorder traversal
            // switch left and right here
            if (q.right != null){
                TreeNode prev = q.right;
                while (prev.left != q && prev.left != null) {
                    prev = prev.left;
                }
                if (prev.left == null){
                    prev.left = q;
                    q = q.right;
                }
                else {
                    prev.left = null;
                    q = q.left;
                }
            } else {
                q = q.left;
            }
        }
        return (p == null) && (q == null);
    }
}