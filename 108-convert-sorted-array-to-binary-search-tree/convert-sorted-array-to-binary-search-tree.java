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
//  https://www.youtube.com/watch?v=0K0uCMYq5ng&ab_channel=NeetCode
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int left, int right, int[] nums) {
        if (left > right) { // base case
            return null;
        }

        int mid = left + ((right - left) / 2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums); // left of arr to construct left subtree
        root.right = helper(mid + 1, right, nums); // right of arr to construct right subtree

        return root;
    }
}