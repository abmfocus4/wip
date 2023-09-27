class Solution {
    // Brute force solution

    // Have two matrixes, Space=O(mn*2) = O(mn)
    // Time: O(mn * (m+n))
    
    // Time: traversing through each element of the matrix and for each elemnt each row and col again
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] resMatrix = new int[rows][cols];

        // create a copy of the original matrix
        // Space: O(mn)
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                resMatrix[i][j] = matrix[i][j];
            }
        }


        // traverse through original matrix
        // if you find 0; set row and column in resMatrix to 0
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                if (matrix[i][j] == 0) {
                    // setting row to 0
                    for (int res_i = 0; res_i < rows; res_i++) {
                        resMatrix[res_i][j] = 0;
                    }

                    // setting col to 0
                    for (int res_j = 0; res_j < cols; res_j++) {
                        resMatrix[i][res_j] = 0;
                    }
                }
            }
        }

        // copy resMatrix to original matrix
        for (int i = 0; i<rows; i++) {
            for (int j = 0; j<cols; j++) {
                matrix[i][j] = resMatrix[i][j];
            }
        }
    }
}