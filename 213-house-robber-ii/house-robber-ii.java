// Expl: https://www.youtube.com/watch?v=ucmqYGVGQK8
class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];

        int[] skipLastHouse = new int[nums.length-1];
        int[] skipFirstHouse = new int[nums.length-1];

        for (int i = 0; i < nums.length -1; i++) {
            skipLastHouse[i] = nums[i];
            skipFirstHouse[i] = nums[i+1];
        }

        int skipLastHouseLoot = robRow(skipLastHouse);
        int skipFirstHouseLoot = robRow(skipFirstHouse);

        return Math.max(skipLastHouseLoot, skipFirstHouseLoot);
    }

    private int robRow(int[] nums) {
        int curMax = 0, prevMax = 0, temp = 0;
        for (int num : nums) {
            temp = curMax;
            curMax = Math.max(num+prevMax, curMax);
            prevMax = temp;
        }

        return curMax;
    }
}

