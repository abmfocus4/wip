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
    public int maxLevelSum(TreeNode root) {
    int max = Integer.MIN_VALUE;
    int maxLevel = 0;
    Queue<TreeNode> q = new LinkedList();
    if (root != null) {
        q.add(root);
    }
    int curLevel = 0;
    while (q.isEmpty() == false) {
        int levelSize = q.size();
        int levelSum = 0;
        TreeNode cur = null;
        for (int i = 0; i < levelSize; i++) {
            cur = q.poll();
            levelSum += cur.val;
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        curLevel++;
        if (levelSum > max) {
            max = levelSum;
            maxLevel = curLevel;
        }
    }
    
    return maxLevel;
        
        
    }
}