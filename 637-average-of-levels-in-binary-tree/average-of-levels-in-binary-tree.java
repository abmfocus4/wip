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
 // simple bfs avg at each level
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if (root != null)
            q.add(root);
        while (q.isEmpty() == false) {
            int levelSize = q.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                levelSum += cur.val;
            }

            result.add((double)levelSum/levelSize);
        }

        return result;
    }
}