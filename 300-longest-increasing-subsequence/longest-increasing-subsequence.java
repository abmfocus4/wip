// https://www.youtube.com/watch?v=hbN20guU5pM
// Time: O(nlogn), Space: O(n)

// verbal explanation of tail arr and replace and insert decision
// https://leetcode.com/problems/longest-increasing-subsequence/description/comments/1570655
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < N; i++) {
            if (nums[i] > sub.get(sub.size()-1)) { // new size subsequence
                sub.add(nums[i]);
            } else { // replace or insert in between
                int index = binarySearch(nums[i], sub);
                sub.set(index, nums[i]);
            }
        }
        return sub.size();
    }

    // checking tail
    private int binarySearch(int num, List<Integer> sub) {
        int left = 0;
        int right = sub.size() - 1;
        while (left < right) {
            int mid = (left + right)/2;
            if (sub.get(mid) == num) {
                return mid; // replace
            }
            if (sub.get(mid) < num) {
                left = mid + 1; // insert
            } else {
                right = mid;
            }
        }
        return left;
    }
}