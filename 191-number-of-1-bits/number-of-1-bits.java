// n & (n - 1) drops the lowest set bit
// Ref: https://leetcode.com/problems/number-of-1-bits/?envType=list&envId=pxw54vnt
public class Solution {
    // you need to treat n as an unsigned value
    // could take stack space O(logn) whereas current iterative sol'n is O(1)
    public int hammingWeight(int n) {
        return (n != 0) ? 1 + hammingWeight(n & (n-1)) : 0; 
    }
}