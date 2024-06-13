class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int col = colBegin; col <= colEnd; col++) {
                result.add(matrix[rowBegin][col]);
            }
            rowBegin++;

            for (int row = rowBegin; row <= rowEnd; row++) {
                result.add(matrix[row][colEnd]);
            }
            colEnd--;

//  len(row) != len(col)
//  Take a 1X3 matrix
            if (rowBegin <= rowEnd) {
                for (int col = colEnd; col >= colBegin; col--) {
                    result.add(matrix[rowEnd][col]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                for (int row = rowEnd; row >= rowBegin; row--) {
                    result.add(matrix[row][colBegin]);
                }
            }
            colBegin++;
        }

        return result;
    }
}