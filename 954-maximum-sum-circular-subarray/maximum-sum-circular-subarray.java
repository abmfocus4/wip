// https://youtube.com/watch?v=Za8V4wkZKkM&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=21&ab_channel=codestorywithMIK
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int max_sum = kadaneMax(nums);
        int min_sum = kadaneMin(nums);

        if (max_sum > 0) {
            return Math.max(max_sum, totalSum - min_sum); // corner case all -1, -1, -1
        }

        return max_sum;
    }

    private int kadaneMin(int[] nums) {
        int cur_sum = nums[0];
        int min_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur_sum = Math.min(cur_sum + nums[i], nums[i]);
            min_sum = Math.min(cur_sum, min_sum);
        }

        return min_sum;
    }

    private int kadaneMax(int[] nums) {
        int cur_sum = nums[0];
        int max_sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur_sum = Math.max(cur_sum + nums[i], nums[i]);
            max_sum = Math.max(cur_sum, max_sum);
        }

        return max_sum;
    }
}