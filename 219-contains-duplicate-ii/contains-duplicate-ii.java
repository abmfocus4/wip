// https://www.youtube.com/watch?v=ypn0aZ0nrL4&ab_channel=NeetCodeIO
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window_nums = new HashSet(); // O(k)

        int left = 0;
        int right = 0;

        while (right < nums.length) { // O(N)
            if (window_nums.contains(nums[right])) { // found dup in window
                return true;
            }
            window_nums.add(nums[right]);
            right++;
            if (right - left > k) { // update front of sliding window
                window_nums.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}