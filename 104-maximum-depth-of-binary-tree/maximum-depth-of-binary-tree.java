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
 // BFS (BREADTH FIRST SEARCH)
 // LEVEL ORDER TRAVERSAL
 // ITERATIVE APPROACH
class Solution {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode cur = null;
        while (root != null && !queue.isEmpty()) {
            count = queue.size();
            while (count != 0) {
                cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                count--;
            }
            ans++;
        }
        return ans;
    }
}
