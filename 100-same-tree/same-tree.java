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

        TreeNode pCur = p;
        TreeNode qCur = q;

        while (pCur != null && qCur != null) {
            if (pCur.val != qCur.val) {
                return false;
            }
            TreeNode pPrev = pCur.left, qPrev = qCur.left;

            while (pPrev != null && pPrev.right != null && pPrev.right != pCur) {
                pPrev = pPrev.right;
            }

            while (qPrev != null && qPrev.right != null && qPrev.right != qCur) {
                qPrev = qPrev.right;
            }

            if (pPrev == null ^ qPrev == null) return false;

            if (pPrev == null) {
                pCur = pCur.right;
            } else if (pPrev.right == null) {
                pPrev.right = pCur;
                pCur = pCur.left;
            } else {
                pPrev.right = null;
                pCur = pCur.right;
            }

            if (qPrev == null) {
                qCur = qCur.right;
            } else if (qPrev.right == null) {
                qPrev.right = qCur;
                qCur = qCur.left;
            } else {
                qPrev.right = null;
                qCur = qCur.right;
            }
        }

        return pCur == null && qCur == null;


    }
}