class Solution {
	Integer[] dp;
    public int jump(int[] nums) {
        dp=new Integer[nums.length];
        return jump(0,nums);        
    }
    private int jump(int curIdx, int[] nums) {
        int n = nums.length;
        if(curIdx >= n-1) // don't forget greater
            return 0;

        if(dp[curIdx] != null)
            return dp[curIdx];

        int minSteps = n; // max steps you can take // don't know why can't set to max value int
        for(int jump=1;jump<=nums[curIdx];jump++) 
            minSteps = Math.min(minSteps, 1+jump(curIdx+jump, nums));

        return dp[curIdx]=minSteps;
    }
}