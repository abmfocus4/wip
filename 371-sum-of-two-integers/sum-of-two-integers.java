// Ref: https://www.youtube.com/watch?v=gVUrDV4tZfY&ab_channel=NeetCode
// Diagram Ref: https://leetcode.com/problems/sum-of-two-integers/description/comments/1575244
class Solution {
    // Time O(1) since a and b bounds are constant otherwise could have been O(n)
    public int getSum(int a, int b) {
        while(b != 0) { // will run as long as carry is empty
            int carry = a & b;
            a = a ^ b; // add without carry
            b = carry << 1; // shift left and add it to a
        }
        return a;
    }
}