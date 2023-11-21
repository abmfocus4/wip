// https://www.youtube.com/watch?v=2kaWJaqoutg
// Top down
// Time: O(n^2), Space: O(n)
class Solution {
    Integer[] cache;
    int N;
    int[] nums;
    public int lengthOfLIS(int[] nums) {
        this.N = nums.length;
        this.cache = new Integer[N];
        this.nums = nums;
        int maxLIS = 0;
        for (int i = 0; i < N; i++) { // where to start LIS
            cache[i] = helper(i);
            maxLIS = Math.max(cache[i], maxLIS);
        }
        return maxLIS;
    }

    private int helper(int index) {
        if (cache[index] != null) return cache[index];
        int curVal = nums[index];
        int maxLIS = 0;
        for (int i = index+1; i < N; i++) { // dfs to find max lis from that element to end of arr
            if (curVal < nums[i]) { // next elem should be greater to be part of LIS
                maxLIS = Math.max(maxLIS, helper(i));
            }
        }
        cache[index] = maxLIS + 1;
        return cache[index];
    }
}