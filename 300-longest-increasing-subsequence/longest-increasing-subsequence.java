// nlogn patience sort

// look at https://www.youtube.com/watch?v=on2hvxBXJH4

// take away: intuition

// look at 
// https://www.youtube.com/watch?v=i4NBDE8ZEV8&ab_channel=SuyashiSinghal

// take away: elem >= num[i] is replace condition

// --------------------

// for interview:

// {10, 11, 4, 12, 1, 10}

// do a run through like first link

// outline your steps:
// - Iterate through arr and iterate through list of sub(looked at last elem of each sub to see if we need to append or create new sub)

// - what is time and space complexity of this? discuss?

// - optimize this idea
// - only store tails since that's all we need
// - reduce space since you don't need the actual value of LIS coalesce them and only store tails
// - coalesce condition - use binary search
// - iterate this is not LIS but representative of stream of data we received

// - pics in phone favorites
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
            } else if (sub.get(mid) < num) {
                left = mid + 1; // insert
            } else {
                right = mid;
            }
        }
        return left;
    }
}