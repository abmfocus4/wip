// https://www.youtube.com/watch?v=D2MbogiFXWU&ab_channel=codestorywithMIK
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;

        int sum = 0;
        int minL = Integer.MAX_VALUE;

        while (j < n) {
            sum += nums[j];

            while (sum >= target) {
                minL = Math.min(minL, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minL == Integer.MAX_VALUE ? 0 : minL;

    }
}