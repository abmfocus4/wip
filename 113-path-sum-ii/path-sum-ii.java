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
// https://www.youtube.com/watch?v=eoyO8hOkPNs&ab_channel=codestorywithMIK
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        backtrack(root, targetSum, new ArrayList(), result);
        return result;
    }

    private void backtrack(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        temp.add(root.val); // add current node to path

        if (root.left == null && root.right == null) { // is leaf
            if (targetSum == root.val) {
                result.add(new ArrayList(temp));
            }
        } else { // is not leaf
            backtrack(root.left, targetSum - root.val, temp, result);
            backtrack(root.right, targetSum - root.val, temp, result);
        }

        temp.remove(temp.size() - 1); // remove current node from path
    }
}