// Permutations problem:
// Given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order. That is nothing but a permutation problem.
// We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply following formula:-
// Total permutations = (m+n)! / (m! * n!)
// But as m and n increase size of (m+n)! will also increase
// ref : https://www.youtube.com/watch?v=Z-uMFv_-w2s
class Solution {
    // Recursive solution + top down dp (using cache)
    // Time: exponential for recursive, Space: O(1)
    // Time: O(mn) Space: O(mn)
    int m;
    int n;
    Integer[][] cache;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        cache = new Integer[m][n];
        // returns unique row for the particular row and col
        return helper(0,0);
    }

    private int helper(int row, int col) {
        // go over the boundary
        if (row > m - 1 || col > n - 1) return 0;

        // reached last box
        if (row == m-1 || col == n-1) return 1;

        // if value was previously computed, return value
        if (cache[row][col] != null) return cache[row][col];

        // calculate routes if down box is taken
        int down = helper(row+1, col);
        // calculate routes if right box is taken
        int right = helper(row, col+1);

        // cache populate computed values
        cache[row][col] = down + right;

        return cache[row][col];
    }
}
