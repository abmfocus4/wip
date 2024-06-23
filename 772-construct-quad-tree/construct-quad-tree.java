/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid = grid;
        return solve(0,0,grid.length);
    }

    public Node solve(int x, int y, int n) {
        if (isSame(x, y, n)) {
            return new Node(grid[x][y] != 0, true);
        } else {
            Node root = new Node(grid[x][y] != 0, false);
            root.topLeft = solve(x, y, n/2);
            root.topRight = solve(x, y+n/2, n/2);
            root.bottomLeft = solve(x+n/2, y, n/2);
            root.bottomRight = solve(x+n/2, y+n/2, n/2);
            return root;
        }
    }

    private boolean isSame(int x, int y, int n) {
        int val = grid[x][y];
        for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }

        return true;
    }
}