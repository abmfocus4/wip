class Solution {
    // Use 2 ref arrs for rows and cols that have all elements 0
    // Time: O(mn)
    // Space: O(m+n)
    public void setZeroes(int[][] matrix) {
        // sizes used later
        int rows = matrix.length;
        int cols = matrix[0].length;

        // reference arrs
        int[] rowsArr = new int[rows];
        int[] colsArr = new int[cols];
        Arrays.fill(rowsArr, -1); // init so that they don't have 0s to begin with
        Arrays.fill(colsArr, -1);

        // traverse through each element of matrix
        // Time: O(mn)
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                // if value in matrix is 0, set corresponding row and col to 0 in arrs
                if (matrix[i][j] == 0) {
                    rowsArr[i] = 0;
                    colsArr[j] = 0;
                }
            }
        }

        // traverse through each element of matrix
        // Time: O(mn)
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                // if ref arrays were set to 0, set values to 0
                if (rowsArr[i] == 0 || colsArr[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}