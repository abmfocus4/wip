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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        TreeNode curNode = null;
        while (root != null && q.isEmpty() == false) {
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList();
            while (levelSize != 0) {
                curNode = q.poll();
                levelList.add(curNode.val);
                if (curNode.left != null) q.add(curNode.left);
                if (curNode.right != null) q.add(curNode.right);
                levelSize--;
            }
            list.add(levelList);
        }

        return list;
    }
}