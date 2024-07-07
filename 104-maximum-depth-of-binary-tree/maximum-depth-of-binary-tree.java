class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root) {
        int currDepth = 0;
        int maxDepth = 0;

        while (root != null) {
            if (root.left == null) {
                root = root.right;
                ++currDepth;
                maxDepth = Math.max(maxDepth, currDepth);
            } else {
                TreeNode pred = root.left;
                int depth = 2;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                    ++depth;
                }

                if (pred.right == null) {
                    pred.right = root;
                    root = root.left;
                    ++currDepth;
                } else {
                    pred.right = null;
                    root = root.right;
                    currDepth -= depth;
                    ++currDepth;
                    maxDepth = Math.max(maxDepth, currDepth);
                }
            }
        }
        return maxDepth;
    }
}
