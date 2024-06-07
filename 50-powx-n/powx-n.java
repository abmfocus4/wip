// https://www.youtube.com/watch?v=7wcJXZoGKMI&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=4&ab_channel=codestorywithMIK
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
                return solve(x*x, n/2);
            } else {
                return solve(x*x, (n-1)/2) * x;
            }
        }
    }
}