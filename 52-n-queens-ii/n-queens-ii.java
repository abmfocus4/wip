class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, n, 0, 0, 0);
    }

    private int backtrack(int col, int n, int left, int topLeft, int bottomLeft) {
        if (col == n) {
            return 1;
        }

        int total = 0;
        for (int row = 0; row < n; row++) {
            int curLeft = row;
            int curTopLeft = row - col + n;
            int curBottomLeft = row + col;

            if (((left & (1 << curLeft)) == 0) &&
                    (topLeft & (1 << curTopLeft)) == 0 &&
                        (bottomLeft & (1 << curBottomLeft)) == 0) 
            {
                left |= (1 << curLeft);
                topLeft |= (1 << curTopLeft);
                bottomLeft |= (1 << curBottomLeft);

                total += backtrack(col + 1, n, left, topLeft, bottomLeft);

                left ^= (1 << curLeft);
                topLeft ^= (1 << curTopLeft);
                bottomLeft ^= (1 << curBottomLeft);
            }
        }
        return total;
    }
}