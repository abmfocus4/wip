class Solution {
    public double myPow(double x, int n) {
        return binaryExp(x, (long)n);
    }

    private double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            x = 1.0/x;
            n *= -1;
        }

        double result = 1;
        while (n != 0) {
            if (n % 2 == 1) {
                result *= x;
                n = n-1;
            }
            x = x*x;
            n = n/2;
        }
        return result;
    }
}