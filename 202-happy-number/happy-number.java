// https://leetcode.com/problems/happy-number/solutions/3767573/easy-java-solution-two-pointers-floyd-s-tortoise-and-hare-detailed-explanation
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast)); // have to use do while first
            if (fast == 1) {
                return true;
            }
        } while (fast != slow);

        return false;
    }

    private int getSumOfSquares(int n) {
        int res = 0;
        while (n != 0) {
            int remainder = n % 10;
            res += (remainder * remainder);
            n /= 10;
        }
        return res;
    }
}