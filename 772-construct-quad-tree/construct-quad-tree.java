
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
// https://www.youtube.com/watch?v=tzABQFpl6Mk&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=25&ab_channel=codestorywithMIK
class Solution {
    public Node construct(int[][] grid) {
        return solve(grid, 0, 0, grid.length);
    }

    private Node solve(int[][] grid, int x, int y, int n) {
        if (isSameValue(grid, x, y, n)) {
            return new Node(grid[x][y] != 0, true); // leaf node
        } else {
            Node root = new Node(grid[x][y] != 0, false); // simple trick to convert int to boolean
            root.topLeft = solve(grid, x, y, n/2);
            root.topRight = solve(grid, x, y+n/2, n/2);
            root.bottomLeft = solve(grid, x+n/2, y, n/2);
            root.bottomRight = solve(grid, x+n/2, y+n/2, n/2);
            return root;
        }
    }

    private boolean isSameValue(int[][] grid, int x, int y, int n) {
        int val = grid[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }

        return true;
    }

// follow up - https://leetcode.com/problems/construct-quad-tree/description/comments/1569993
    public Node construct2(int[][] grid) {
        // Setting one by one to test the code
        Node root = new Node(true, true);
        int size = grid.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                root = set(i, j, size, root, grid[i][j] != 0);
            }
        }

        return root;
    }

    private Node set(int i, int j, int size, Node currNode, boolean setVal) {

        if (currNode.isLeaf) {
            if (currNode.val == setVal) {
                return currNode; // Nothing to do
            }

            if (size == 1) { // set val and parent may need to MERGE
                currNode.val = setVal;
                return currNode;
            }

            // SPLIT curr node (add children) and continue TRAVERSAL
            currNode.topLeft = new Node(currNode.val, true);
            currNode.topRight = new Node(currNode.val, true);
            currNode.bottomLeft = new Node(currNode.val, true);
            currNode.bottomRight = new Node(currNode.val, true);
            currNode.isLeaf = false;
        }

        // TRAVERSAL
        int mid = size / 2;
        if (0 <= i && i < mid) {
            if (0 <= j && j < mid) {
                currNode.topLeft = set(i, j, mid, currNode.topLeft, setVal); // topLeft has the change
            } else {
                currNode.topRight = set(i, j - mid, mid, currNode.topRight, setVal); // topRight has the change
            }
        } else {
            if (0 <= j && j < mid) {
                currNode.bottomLeft = set(i - mid, j, mid, currNode.bottomLeft, setVal); // bottomLeft has the change
            } else {
                currNode.bottomRight = set(i - mid, j - mid, mid, currNode.bottomRight, setVal); // bottomRight has the
                                                                                                 // change
            }
        }

        // MERGE: iff all children are leaves with the same value
        if (currNode.topLeft.isLeaf && currNode.topRight.isLeaf &&
                currNode.bottomLeft.isLeaf && currNode.bottomRight.isLeaf &&
                currNode.topLeft.val == setVal && currNode.topRight.val == setVal &&
                currNode.bottomLeft.val == setVal && currNode.bottomRight.val == setVal) {
            currNode.isLeaf = true;
            currNode.val = setVal;
            currNode.topLeft = currNode.topRight = currNode.bottomLeft = currNode.bottomRight = null;
        }

        return currNode;
    }
}