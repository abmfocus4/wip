// https://www.youtube.com/watch?v=DEJAZBq0FDA&ab_channel=NeetCode
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1; // left pointer where nums[i] needs to be stored
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}