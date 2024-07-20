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
    HashMap<Long, Integer> prefixSumFreq;
    int k;
    int count;
    public int pathSum(TreeNode root, int targetSum) {
        this.k = targetSum;
        this.prefixSumFreq = new HashMap();
        this.count = 0;
        preorder(root, 0L);
        return count;
    }

    private void preorder(TreeNode root, long prefixSum) {
        if (root == null) return;
        
        prefixSum += root.val;

        // continuous sum case
        if (prefixSum == k) {
            count++;
        }

        count += prefixSumFreq.getOrDefault(prefixSum - k, 0);

        prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);

        preorder(root.left, prefixSum);
        preorder(root.right, prefixSum);

        prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) - 1);

    }
}