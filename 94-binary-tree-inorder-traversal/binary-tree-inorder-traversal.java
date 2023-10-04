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

// Left -> Root -> Right
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack();

        while (root != null || !stack.isEmpty()) { // be careful - use || and not &&
            while (root != null) { // left traversal
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val); // left or root
            root = root.right; // traverse right tree
        }

        return list;
}
}