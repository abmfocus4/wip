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

    private String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }
    String nullStr = "#";
    String delimit = ",";
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(delimit).append(nullStr);
        } else {
            sb.append(delimit).append(root.val);
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
        
    }

    private boolean kmp(String word, String pattern) {
        int[] lps = getLPS(pattern);
        for (int i = 0, j = 0; i < word.length(); i++) {
            while (word.charAt(i) != pattern.charAt(j) && j > 0) j = lps[j-1];
            if (word.charAt(i) == pattern.charAt(j)) ++j;
            if (j == pattern.length())  return true;
        }

        return false;
    }

    private int[] getLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while(pattern.charAt(i) != pattern.charAt(j) && j > 0) j = lps[j-1];
            if (pattern.charAt(i) == pattern.charAt(j)) lps[i] = ++j;
        }
        return lps;
    }
}