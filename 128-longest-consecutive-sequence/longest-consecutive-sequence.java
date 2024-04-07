class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0; // corner case
        Arrays.sort(nums); // sorting nums
        int val= nums[0]; // init num
        int count=1; int maxCount =0;
        for(int i:nums){
            if(i==val) continue;
            else if (i == (val + 1)){
                ++val; ++count;
            }else{
                if (count > maxCount) maxCount = count; // update max
                count = 1; // reset counters
                val=i;
            }
        }
        if (count > maxCount) maxCount = count; // find count check
        return maxCount;
    }
}