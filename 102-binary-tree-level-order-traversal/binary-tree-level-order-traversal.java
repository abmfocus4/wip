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
        // use queue to store each level consequtively
        // loop through the level nodes and left and right nodes and append val to list
        // add the list to the list of lists after for loop
        // return list of lists at the end
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            int levelLength = q.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < levelLength; i++) {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}