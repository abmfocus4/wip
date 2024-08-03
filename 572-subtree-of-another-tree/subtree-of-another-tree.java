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
        // serialize root
        // serialize subroot
        // kmp compare

        return kmp(serialize(root), serialize(subRoot));
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    String nullStr = "$";
    String delimit = ",";
    public void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(delimit).append(nullStr);
        } else {
            sb.append(delimit).append(root.val);
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }

    public boolean kmp(String word, String pattern) {
        int[] lps = getLPS(pattern);
        // iterate through each char of word
        int m = word.length();
        int j = 0;
        for (int i = 0; i < m; i++) {
            while (word.charAt(i) != pattern.charAt(j) && j > 0) j = lps[j-1];
            if (word.charAt(i) == pattern.charAt(j)) ++j;
            if (j == pattern.length()) return true;
        }
        return false;
    }

    private int[] getLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (pattern.charAt(i) != pattern.charAt(j) && j > 0) j = lps[j-1];
            if (pattern.charAt(i) == pattern.charAt(j)) lps[i] = ++j;
        }
        return lps;
    }
}