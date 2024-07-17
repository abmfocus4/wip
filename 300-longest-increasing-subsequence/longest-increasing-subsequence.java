class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tailList = new ArrayList();
        tailList.add(nums[0]);
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > tailList.get(tailList.size() - 1)) {
                tailList.add(nums[i]);
            } else { // if prev is greater, than start new list or update previous lists
                int index = binarySearch(tailList, nums[i]);
                tailList.set(index, nums[i]);
            }
        }

        return tailList.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int n = list.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}