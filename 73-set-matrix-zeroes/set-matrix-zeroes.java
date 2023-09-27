class Solution {
    // Use first row and col as ref arrs
    // but we don't know if the first row and col need to be 0 as well
    // these first row and col become 0, if any of the values in the first row and any of the values in the first col are 0 respectively
    // to check if they should be 0, use two bools

    // Time: O(mn)
    // Space: O(1)
    public void setZeroes(int[][] matrix) {
        // to be used later
        int rows = matrix.length;
        int cols = matrix[0].length;

        // checking if first row and col need to be set to 0
        boolean isRow0 = false;
        boolean isCol0 = false;

        // checking if first col needs to be set to 0
        for (int i=0; i<rows; i++) {
            if (matrix[i][0] == 0) { // if any of the values of the first col are 0
                isCol0 = true;
            }
        }

        // checking if first row need to be set to 0
        for (int i=0; i<cols; i++) {
            if(matrix[0][i] == 0) { // if any of the values of the row are 0
                isRow0 = true;
            }
        }

        // traverse to remaining elements of matrix
        for (int i=1; i<rows; i++) { // starts at 1
            for(int j=1; j<cols; j++) { // starts at 1
                if (matrix[i][j] == 0) { // if value is 0
                    matrix[0][j] = 0; // set corresponding first row value to 0
                    matrix[i][0] = 0; // set corresponding first col value to 0
                }
            }
        }

        // traverse through remaining elements again to use the first row and col as reference and set the whole remaining matrix to 0 if needed
        for (int i=1; i<rows; i++) {
            for(int j=1; j<cols; j++) {
                // if corresponding first row and col either have 0
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // setting values of first row 0
        if (isRow0) {
            for (int i=0; i<cols; i++) {
                matrix[0][i] = 0;
            }
        }

        // setting values of first col as 0
        if (isCol0) {
            for (int i=0; i<rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}