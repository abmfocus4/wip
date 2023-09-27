class Solution {
    // dp: bottom up 
    // Time/Space: O(mn)
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        // fill all row boundaries to 1 because only 1 direction can go (up or down you go out of grid)
        for(int[] row : cache) {
            Arrays.fill(row, 1);
        }

        // calculate grid values from target to up and down to reach 0,0
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int up = cache[i+1][j];
                int left = cache[i][j+1];
                cache[i][j] = up + left;
            }
        }

        return cache[0][0];
    }
}