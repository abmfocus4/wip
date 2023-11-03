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

// https://leetcode.com/problems/subtree-of-another-tree/solutions/474425/java-python-2-solutions-naive-serialize-in-preorder-then-kmp-o-m-n-clean-concise/?envType=list&envId=pxw54vnt

// search KMP algorithm - used for pattern matching

// Time Complexity:
// Serialization takes O(m + n) since you visit each node once
// kmp worst case take O(m + n) - https://www.youtube.com/watch?v=V5-7GzOfADQ

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return kmp(serialize(root), serialize(subRoot));
    }

    private String serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            preorder(node, sb);
        }
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",#");
        } else {
            sb.append("," + node.val);
            preorder(node.left, sb);
            preorder(node.right, sb);
        }
    }

    private boolean kmp(String rootStr, String subRootStr) {
        int[] lps = getLPS(subRootStr);
        int n = rootStr.length(), m = subRootStr.length();
        for (int i = 0, j = 0; i < n; i++) { // only move one way in primary string
            while (rootStr.charAt(i) != subRootStr.charAt(j) && j > 0) j = lps[j-1]; // only j moves
            if (rootStr.charAt(i) == subRootStr.charAt(j)) ++j;
            if (j == m) return true;
        }
        return false;
    }

    private int[] getLPS(String subRootStr) {
        int m = subRootStr.length();
        int[] lps = new int[m];
        for (int i = 1, j = 0; i < m; i++) { // pi table or lps table
            while (subRootStr.charAt(i) != subRootStr.charAt(j) && j > 0) j = lps[j-1];
            if (subRootStr.charAt(i) == subRootStr.charAt(j)) lps[i] = ++j;
        }
        return lps;
    }
}
