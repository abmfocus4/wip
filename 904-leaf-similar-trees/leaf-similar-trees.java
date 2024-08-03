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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // get leaves from left to right for both nodes
        // compare

        List<Integer> list1 = getLeafNodes(root1);
        List<Integer> list2 = getLeafNodes(root2);
        return list1.equals(list2);
    }

    private List<Integer> getLeafNodes(TreeNode root) {
        List<Integer> list = new ArrayList();
        if (root == null) return list;
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            list.addAll(getLeafNodes(root.left));
            list.addAll(getLeafNodes(root.right));
        }

        return list;
    }
}