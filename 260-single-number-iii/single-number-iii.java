// https://www.youtube.com/watch?v=faoVORjd-T8&ab_channel=NeetCodeIO
class Solution {
    public int[] singleNumber(int[] nums) {
        // xor all numbers - even num times appearing numbers are removed
        // xor result is the xor of the two different numbers
        // we need to separate these two numbers
        // where we see 1s is where the bit was different
        // we can use this bit to divide 1st result from 2nd result
        // xor two groups and get two numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int diffBit = 0;
        for (int k = 0; k <=  31; k++) {
            int mask = (1 << k);
            if ((xor & mask) != 0) {
                diffBit = k;
                break;
            }
        }

        int group1 = 0;
        int group2 = 0;
        int groupMask = (1 << diffBit);
        for (int num : nums) {
            if ((num & groupMask) != 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }

        return new int[] {group1,group2};
    }
}