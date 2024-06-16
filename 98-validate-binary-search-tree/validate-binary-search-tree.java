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
//  https://www.youtube.com/watch?v=80Zug6D1_r4&list=TLPQMTYwNjIwMjTwkIyyJmy5Kg&index=1&ab_channel=takeUforward
// Morris Traversal
// Threaded Binary Tree Concept
// O(n) amortized time, O(1) space
class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode cur = root;
        TreeNode comp = null;
        while (cur != null) {
            if (cur.left == null) { // case 1:
                if(comp != null && comp.val >= cur.val){
                    return false;
                }
                comp = cur;                
                cur = cur.right;
            } else {
                TreeNode prev = cur.left; // left subtree
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right; // go to the rightmost child of left subtree
                }
                if (prev.right == null) { // case 2: first visit
                    prev.right = cur; // make the threaded connection
                    cur = cur.left; // traverse left
                } else { // case 3: threaded connection already exists
                    prev.right = null; // remove connection
                    if(comp != null && comp.val >= cur.val){
                        return false;
                    }
                    comp = cur;                
                    cur = cur.right; // move to right (LN)R
                }

            }
        }

        return true;
    }
}