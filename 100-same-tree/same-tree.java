class Solution {
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        TreeNode c1 = root1, c2 = root2;
        while (c1 != null && c2 != null) {

            if (c1.val != c2.val) return false;

            TreeNode pre1 = c1.left, pre2 = c2.left;

            while (pre1 != null && pre1.right != null && pre1.right != c1) {
                pre1 = pre1.right;
            }
            while (pre2 != null && pre2.right != null && pre2.right != c2) {
                pre2 = pre2.right;
            }
            
            if (pre1 == null ^ pre2 == null) return false;
            
            if (pre1 == null) { // if left is null
                c1 = c1.right;
            } else if (pre1.right == null) {
                pre1.right = c1;
                c1 = c1.left;
            } else {
                pre1.right = null;
                c1 = c1.right;
            }
            
            if (pre2 == null) {
                c2 = c2.right;
            } else if (pre2.right == null) {
                pre2.right = c2;
                c2 = c2.left;
            } else {
                pre2.right = null;
                c2 = c2.right;
            }
        }
        return c1 == null && c2 == null;
    }
}