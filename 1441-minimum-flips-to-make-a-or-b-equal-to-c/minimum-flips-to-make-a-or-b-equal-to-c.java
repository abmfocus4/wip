// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/solutions/479998/c-bitwise-xor-solution-1-line
class Solution {
    public int minFlips(int a, int b, int c) {
        return Integer.bitCount(c ^ (a|b)) + Integer.bitCount(~c & (a & b));
    }
}