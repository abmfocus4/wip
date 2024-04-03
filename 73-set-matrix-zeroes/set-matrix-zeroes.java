class Solution {
    public void setZeroes(int[][] matrix) {
        // at max you set all rows and all cols to 0 (m+n) so you need m + n flags
        // two arrays, row flags and col flags
        // traverse matrix and flags
        // traverse flag arrs and set matrix values to 0

        int rows = matrix.length, cols = matrix[0].length;
        int[] rowFlags = new int[rows];
        int[] colFlags = new int[cols];

        Arrays.fill(rowFlags, -1);
        Arrays.fill(colFlags, -1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowFlags[i] = 0;
                    colFlags[j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            if (rowFlags[i] == 0) {
                for (int c = 0; c < cols; c++) {
                    matrix[i][c] = 0;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            if (colFlags[i] == 0) {
                for (int r = 0; r < rows; r++) {
                    matrix[r][i] = 0;
                }
            }
        }
    }
}