class Solution {
    // bottom up dp approach space optimization
    public int climbStairs(int n) {
        // base case
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) { // step calculation after base case
            int temp = cur;
            cur = prev + cur; // sum last value with current value
            prev = temp; // assign to old current value
        }

        return cur;
    }
}