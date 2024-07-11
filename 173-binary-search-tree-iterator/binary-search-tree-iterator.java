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
class BSTIterator {
    TreeNode cur; // pointer to current node in iteration
    public BSTIterator(TreeNode root) {
        this.cur = root;
    }
    
    public int next() {
        TreeNode next = morris(); // run morris to update current pointer
        return next.val;
    }
    
    public boolean hasNext() {
        return cur != null; // if tree is traversed
    }

    private TreeNode morris() {
        TreeNode res = null; // extra pointer to return current spot in traversal
        while (cur != null) {
            if (cur.left == null) { // same as original morris. where there is print, set res = null and break after traversal
                res = cur; // node process
                cur = cur.right;
                break;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    res = cur; // node process
                    prev.right = null;
                    cur = cur.right;
                    break;
                }
            }
        }
        return res;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */