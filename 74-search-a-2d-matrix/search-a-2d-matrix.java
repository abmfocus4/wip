// https://www.youtube.com/watch?v=NYk3IuJinuc&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=22&ab_channel=codestorywithMIK
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m*n - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int row = mid/n, col = mid%n; // 1d to 2d mapping
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}