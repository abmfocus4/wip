class Solution {
    public int removeDuplicates(int[] nums) {
        int cur_index = 0;
        int k = 2; // generalize for k duplicates
        for (int num : nums) {
            // check curr num with num before 2 index
            if (cur_index < k || num != nums[cur_index - k]) {
                nums[cur_index] = num; // move it to the front
                cur_index++;
            }
        }

        return cur_index;
    }
}