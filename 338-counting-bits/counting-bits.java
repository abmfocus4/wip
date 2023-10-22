// Time: O(nlogn)
class Solution {
    public int[] countBits(int n) {
        // loop 0...n
        // each i, while i != 0
        // mask and save ones count and shift
        int[] res = new int[n+1];
        for (int i = 0; i<= n; i++) {
            int digit = i;
            int count = 0;
            while (digit != 0) {
                if ((digit & 1) == 1) count++;
                digit >>= 1;
            }
            res[i] = count;
        }
        return res;
    }
}