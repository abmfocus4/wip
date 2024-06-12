// https://www.youtube.com/watch?v=7wcJXZoGKMI&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=4&ab_channel=codestorywithMIK

// https://leetcode.com/problems/powx-n/solutions/1337794/java-c-simple-o-log-n-easy-faster-than-100-explained
class Solution {
    public double myPow(double x, int n) {
        return solve(x, n);
    }

    private double solve(double x, long n) {
        if (n == 0) return 1;

        if (n < 0) {
            return solve(1/x, -n);
        } else {
            if (n % 2 == 0) {
                return solve(x*x, n/2); // n >>>= 1 same as n/2
            } else { // (n & 1) if 0  even
                return solve(x*x, (n-1)/2) * x;
            }
        }
    }
}