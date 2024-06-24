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
    HashMap<Long, Integer> prefixMap;
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        this.count = 0;
        prefixMap = new HashMap();
        backtrack(root, targetSum, 0L);
        return count;
    }

    private void backtrack(TreeNode root, int targetSum, long prefixSum) {
        if (root == null) return;

        prefixSum += root.val;
        if (prefixSum == targetSum) {
            count++;
        }

        if (prefixMap.containsKey(prefixSum - targetSum)) {
            count += prefixMap.get(prefixSum - targetSum);
        }

        prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);

        backtrack(root.left, targetSum, prefixSum);
        backtrack(root.right, targetSum, prefixSum);

        prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) - 1);

    }
}