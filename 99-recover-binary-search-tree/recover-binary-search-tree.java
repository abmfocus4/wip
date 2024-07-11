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
//  https://leetcode.com/problems/recover-binary-search-tree/solutions/32559/detail-explain-about-how-morris-traversal-finds-two-incorrect-pointer
// just replace normal inorder with morris
// and instead of printing node, process node
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

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                processNode(cur);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    processNode(cur);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public void processNode(TreeNode root) {
        if (root == null) {
            return;
        }

        if (firstNode == null && prevNode != null && prevNode.val >= root.val) {
            firstNode = prevNode;
        }

        if (firstNode != null && prevNode != null && prevNode.val >= root.val) {
            secondNode = root;
        }

        prevNode = root;
    }
}