// https://www.youtube.com/watch?v=LK0c7tCzKmM&list=TLPQMDYwNjIwMjTGU_sP9Ubjew&index=4&ab_channel=codestorywithMIK
class Solution {
    public int singleNumber(int[] nums) {
        // TC: O(32*n)
        int result = 0;
        for (int k = 0; k <= 31; k++) {
            int mask = 1 << k;

            int countZeroes = 0;
            int countOnes = 0;

            for (int num : nums) {
                if ((num & mask) == 0) {
                    countZeroes++;
                } else {
                    countOnes++;
                }
            }
            if ((countOnes % 3) == 1) {
                result |= mask;
            }
        }

        return result;
    }
}