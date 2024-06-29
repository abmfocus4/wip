class Solution {
    int max = 0;
    public enum DIR {
        LEFT, RIGHT
    }
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        zigZag(root.left, 0, DIR.LEFT);
        zigZag(root.right, 0, DIR.RIGHT);
        return max;
    }
    private void zigZag(TreeNode node, int depth, DIR direction) { //direction: true is right, false is left
        max = Math.max(max, depth);
        if(node == null) return;
        zigZag(node.left, (direction == DIR.RIGHT) ? depth+1: 0, DIR.LEFT); //if previous direction was right, and now going left, we add 1 to depth, else starting again as 0
        zigZag(node.right, (direction == DIR.LEFT) ? depth+1: 0, DIR.RIGHT);
    }
}