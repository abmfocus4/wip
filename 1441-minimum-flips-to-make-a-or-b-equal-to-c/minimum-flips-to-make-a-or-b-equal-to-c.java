// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/solutions/479998/c-bitwise-xor-solution-1-line
class Solution {
    public int minFlips(int a, int b, int c) {
        int firstCase  = (c ^ (a|b));
        int secondCase = firstCase & (a&b); // case where a and b is 1 and c is 0
        return Integer.bitCount(firstCase) + Integer.bitCount(secondCase);
    }
}