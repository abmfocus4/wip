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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        rightSideView(root, result, 0);
        return result;
    }

    public void rightSideView(TreeNode cur, List<Integer> result, int depth) {
        if (cur == null) {
            return;
        }

        if (result.size() == depth) { // if you are at depth then add value
            result.add(cur.val);
        }

        rightSideView(cur.right, result, depth+1); // check right
        rightSideView(cur.left, result, depth+1); // check left
    }
}