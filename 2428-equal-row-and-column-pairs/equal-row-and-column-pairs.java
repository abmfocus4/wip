class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length, ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int hashVal = 0;
            for (int j = 0; j < n; j++) {
                hashVal = grid[i][j] + 11 * hashVal;
            }
            mp.put(hashVal, mp.getOrDefault(hashVal, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            int hashVal = 0;
            for (int i = 0; i < n; i++) {
                hashVal = grid[i][j] + 11 * hashVal;
            }
            ans += mp.getOrDefault(hashVal,0);
        }
        return ans;
    }
}