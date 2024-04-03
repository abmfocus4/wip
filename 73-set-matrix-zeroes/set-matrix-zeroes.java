class Solution {
    public void setZeroes(int[][] matrix) {

        // make a copy of matrix
        // traverse orig matrix and set 0s in copy matrix
        // copy matrix to orig matrix data transfer
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] copy = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for (int r = 0; r < rows; r++) {
                        copy[r][j] = 0;
                    }

                    for (int c = 0; c < cols; c++) {
                        copy[i][c] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
    }
}