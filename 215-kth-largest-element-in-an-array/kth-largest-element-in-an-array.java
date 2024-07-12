class Solution {
    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            if (nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i, j);
                i++;
                j--;
            }

            if (nums[i] >= pivot) {
                i++;
            }

            if (nums[j] <= pivot) {
                j--;
            }
        }

        swap(nums, left, j);
        return j;
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        int left = 0;
        int right = n - 1;

        int pivotIdx = 0;

        while (true) {
            pivotIdx = partition(nums, left, right);
            if (pivotIdx == k - 1) {
                break;
            } else if (pivotIdx > k - 1) {
                right = pivotIdx - 1;
            } else {
                left = pivotIdx + 1;
            }
        }
        return nums[pivotIdx];
    }
}