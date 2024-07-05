class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;

        List<Integer> list = new ArrayList();

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int col = colStart; col <= colEnd; col++) {
                list.add(matrix[rowStart][col]);
            }
            rowStart++;

            for (int row = rowStart; row <= rowEnd; row++) {
                list.add(matrix[row][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int col = colEnd; col >= colStart; col--) {
                    list.add(matrix[rowEnd][col]);
                }
                rowEnd--;
            }

            if (colStart <= colEnd) {
                for (int row = rowEnd; row >= rowStart; row--) {
                    list.add(matrix[row][colStart]);
                }
                colStart++;
            }
        }

        return list;
    }
}