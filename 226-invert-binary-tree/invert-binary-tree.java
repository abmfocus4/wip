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
 // Ref: https://leetcode.com/problems/invert-binary-tree/solutions/2463600/easy-100-fully-explained-java-c-python-js-c-python3-recursive-iterative/?envType=list&envId=pxw54vnt

// Recursive
class Solution {
// Time Complexity : O(n)
// Space Complexity : O(n)
    public TreeNode invertTree(TreeNode root) {
        // till queue is empty
        // do a bfs search and add nodes queue
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root != null) q.add(root);
        while (q.isEmpty() != true) {
            TreeNode node = q.poll();
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);

            TreeNode tmp_left = node.left;
            node.left = node.right;
            node.right = tmp_left;
        }

        return root;
    }
}