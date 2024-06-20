// https://www.youtube.com/watch?v=4jBAHd0Xr90&ab_channel=EricProgramming
class Solution {
    // top down memo
    // each cell, starting point for maximal square
    int maxWidth;
    Integer[][] cache;
    int m;
    int n;
    char[][] matrix;

    public int maximalSquare(char[][] matrix) {
        this.matrix = matrix;
        this.maxWidth = Integer.MIN_VALUE;
        this.m = matrix.length;
        this.n = matrix[0].length;
        this.cache = new Integer[m][n];
        helper(0, 0);
        return maxWidth == Integer.MIN_VALUE ? 0 : maxWidth * maxWidth;
    }

    private int helper(int i, int j) {
        if (i >= m || j >= n)
            return 0;

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        // cur width is 0 then set 0 and exit
        // if not, then max of all three plus current width
        // set and return

        int curWidth = matrix[i][j] == '1' ? 1 : 0;

        // todo: for future use
        int right = helper(i, j + 1);
        int down = helper(i + 1, j);
        int rightDiag = helper(i + 1, j + 1);

        if (curWidth == 1) {
            int minWidth = Math.min(right, Math.min(down, rightDiag)); // min not max
            curWidth += minWidth;
        }

        maxWidth = Math.max(curWidth, maxWidth);
        return cache[i][j] = curWidth;
    }
}