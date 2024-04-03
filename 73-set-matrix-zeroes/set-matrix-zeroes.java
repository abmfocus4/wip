class Solution {
    public void setZeroes(int[][] matrix) {
        // use first row and first col as row and col flags
        // check first row and first col and set isRow or isCol flag to 0 if the row or col needs to be set to 0
        // traverse matrix and set first row or col to 0 if cell is 0
        // traverse first row and col and set rest of matrix to 0
        // check row and col flag and set row or col 0

        int rows = matrix.length, cols = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) isRow0 = true;
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) isCol0 = true;
        }

        for (int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isRow0) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (isCol0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}