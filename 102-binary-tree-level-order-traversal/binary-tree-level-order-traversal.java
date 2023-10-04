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
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) queue.add(root); // null check don't forget
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // traverse all nodes in level
            List<Integer> levelList = new ArrayList(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left); // if exists check // add left first
                if (cur.right != null) queue.add(cur.right); // if exists check
                levelList.add(cur.val);
            }
            res.add(levelList);
        }
        return res;
    }
}