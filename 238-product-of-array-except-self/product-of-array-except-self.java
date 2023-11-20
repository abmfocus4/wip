// Ref: https://www.youtube.com/watch?v=tSRFtR3pv74
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        // create left products array
        int[] left_products = new int[N];
        left_products[0] = 1;
        for (int i = 1; i < N; i++) {
            left_products[i] = left_products[i-1] * nums[i-1];
        }

        // create right products array
        int[] right_products = new int[N];
        right_products[N-1] = 1;
        for (int i = N-2; i >= 0; i--) {
            right_products[i] = right_products[i+1] * nums[i+1];
        }

        // create output array
        int[] output_arr = new int[N];
        for (int i = 0; i < N; i++) {
            output_arr[i] = left_products[i] * right_products[i];
        }

        return output_arr;
    }
}