class Solution {
    // bottom up
    // start from i = 1 and j = 1
    // find top, topDiag, left
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m + 1][n + 1]; // i,j maximal square bottom right cell

        // for (int i = 0; i < m; i++) {
        // if (matrix[i][0] == '1') {
        // cache[i][0] = 1;
        // }
        // }

        // for (int i = 0; i < n; i++) {
        // if (matrix[0][i] == '1') {
        // cache[0][i] = 1;
        // }
        // }

        int maxWidth = Integer.MIN_VALUE;

        for (int i = 1; i < m + 1; i++) { // m+1 and n+1
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    int top = cache[i - 1][j];
                    int topDiag = cache[i - 1][j - 1];
                    int left = cache[i][j - 1];
                    int minWidth = Math.min(top, Math.min(topDiag, left));
                    cache[i][j] = 1 + minWidth;
                    maxWidth = Math.max(maxWidth, cache[i][j]);

                }
            }

        }

        return maxWidth == Integer.MIN_VALUE ? 0 : maxWidth * maxWidth;
    }
}