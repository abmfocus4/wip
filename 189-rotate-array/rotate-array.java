// https://www.youtube.com/watch?v=BHr381Guz3Y&ab_channel=NeetCode
class Solution {
    public void rotate(int[] nums, int k) {
    k %= nums.length; // might not be necessary
    reverse(nums, 0, nums.length - 1); // reverse whole array
    reverse(nums, 0, k - 1); // first k elems reverse
    reverse(nums, k, nums.length - 1); // remaining reverse
}

// two ptr reverse
public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
}