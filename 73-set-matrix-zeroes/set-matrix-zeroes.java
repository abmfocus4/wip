class Solution {
    public void setZeroes(int[][] matrix) {
        // check first row is 0 and first col is 0
        // iterate matrix from row, col = 1
        // set flag if matrix[i][j] = 0
        // iterate matrix again, use flags and set cells to 0
        // check isRow0 and isCol0 flags and set first row and col 0 if needed
        int m = matrix.length;
        int n = matrix[0].length;

        // row 1
        boolean isRow0 = false;
        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                isRow0 = true;
                break;
            }
        }

        boolean isCol0 = false;
        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                isCol0 = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }


        if (isCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}