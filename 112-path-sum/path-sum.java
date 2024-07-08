class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        TreeNode prev, cur = root;
        int curSum = 0;
        while (cur != null) {
            if (cur.left == null) {
                curSum += cur.val;
                if (cur.right == null && curSum == targetSum) {
                    return true;
                }
                cur = cur.right;

            } else {
                prev = cur.left;
                int sum = prev.val;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                    sum += prev.val;
                }
                if (prev.right == cur) {
                    prev.right = null;
                    cur = cur.right;
                    curSum -= sum;
                } else { // prev.right == null
                    curSum += cur.val;
                    prev.right = cur;
                    if (prev.left == null && curSum + sum == targetSum) {
                        return true;
                    }
                    cur = cur.left;
                }
            }
        }
        return false;
    }
}
