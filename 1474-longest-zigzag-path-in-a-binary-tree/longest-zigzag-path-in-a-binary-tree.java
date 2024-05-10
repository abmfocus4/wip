class Solution {
    int max = 0;
    public static final boolean left = false;
    public static final boolean right = true;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        zigZag(root.left, 0, left);
        zigZag(root.right, 0, right);
        return max;
    }
    private void zigZag(TreeNode node, int depth, boolean direction) { //direction: true is right, false is left
        max = Math.max(max, depth);
        if(node == null) return;
        zigZag(node.left, (direction == right) ? depth+1: 0, left); //if previous direction was right, and now going left, we add 1 to depth, else starting again as 0
        zigZag(node.right, (direction == left) ? depth+1: 0, right);
    }
}