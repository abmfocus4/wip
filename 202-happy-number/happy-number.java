// https://www.youtube.com/watch?v=ljz85bxOYJ0&ab_channel=NeetCode
class Solution {
    public boolean isHappy(int n) {
        // detect cycle in process where we visit a number twise

        HashSet<Integer> square_sums = new HashSet();

        while (square_sums.contains(n) == false) {
            square_sums.add(n);
            n = getSumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int getSumOfSquares(int n) {
        int output = 0;
        while (n != 0) {
            int last_digit = n % 10;
            output += (last_digit * last_digit);
            n = n / 10;
        }

        return output;
    }
}