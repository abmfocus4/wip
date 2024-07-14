class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        TreeNode cur = root;
        int sum = 0;
        int curSum = 0;
        int depth = 0;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode pre = cur.left;
                depth = 1; // depth for rolling up
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                    depth++;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    curSum = curSum * 10 + cur.val; // go down a level
                    cur = cur.left;
                } else {
                    pre.right = null;
                    if (pre.left == null) sum += curSum; // if right and left are null, leaf node
                    curSum /= Math.pow(10, depth); // rollback to current node
                    cur = cur.right;
                }
            } else {
                curSum = curSum * 10 + cur.val; // node process
                if (cur.right == null) sum += curSum; // left is null, if right is also null
                cur = cur.right;
            }
        }
        return sum;
    }
}
