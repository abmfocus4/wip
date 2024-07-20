class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixSumFreq = new HashMap();
        int count = 0;
        // continuous subarray from start to index
        prefixSumFreq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            count += prefixSumFreq.getOrDefault(prefixSum - k, 0);
            prefixSumFreq.put(prefixSum, prefixSumFreq.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}