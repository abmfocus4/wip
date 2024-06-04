// https://www.youtube.com/watch?v=NYk3IuJinuc&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=22&ab_channel=codestorywithMIK
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;
        while ((i < m) && (j >= 0)) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }

        return false;
    }
}