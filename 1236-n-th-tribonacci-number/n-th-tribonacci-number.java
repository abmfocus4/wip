class Solution {
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (n == 2) {
            return 1;
        }

        int res = 0;

        int prev = 1;
        int prev_prev = 1;
        int prev_prev_prev = 0;

        for (int i = 3; i <= n; i++) {
            res = prev + prev_prev + prev_prev_prev;
            prev_prev_prev = prev_prev;
            prev_prev = prev;
            prev = res;
        }

        return res;
    }
}