// Ref: https://leetcode.com/problems/house-robber/solutions/1605334/java-dp-with-and-without-space-explained/

class Solution {
    public int rob(int[] nums) {
        int curMax = 0, prevMax = 0, temp = 0;
        for (int num : nums) {
            temp = curMax;
            curMax = Math.max(num+prevMax, curMax); // first arg: rob house, snd arg: don't rob
            prevMax = temp;
        }
        return curMax;
    }
}