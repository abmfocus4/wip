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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }

        TreeNode curP = p;
        TreeNode curQ = q;

        while (curP != null && curQ != null) {
            if (curP.val != curQ.val) {
                return false;
            }

            TreeNode prevP = curP.left; 
            TreeNode prevQ = curQ.left;

            while(prevP != null && prevP.right != null && prevP.right != curP) {
                prevP = prevP.right;
            }

            while(prevQ != null && prevQ.right != null && prevQ.right != curQ) {
                prevQ = prevQ.right;
            }

            if (prevP == null ^ prevQ == null) {
                return false;
            } 

            if (prevP == null) {
                curP = curP.right;
            } else if (prevP.right == null) {
                prevP.right = curP;
                curP = curP.left;
            } else {
                prevP.right = null;
                curP = curP.right;
            }

            if (prevQ == null) {
                curQ = curQ.right;
            } else if (prevQ.right == null) {
                prevQ.right = curQ;
                curQ = curQ.left;
            } else {
                prevQ.right = null;
                curQ = curQ.right;
            }
        }

        return curP == null && curQ == null;
    }
}