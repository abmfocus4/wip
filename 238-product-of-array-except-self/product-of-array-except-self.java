// Ref: https://www.youtube.com/watch?v=tSRFtR3pv74
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        // replace left products array with output_arr (reuse output_arr)
        int[] output_arr = new int[N];
        output_arr[0] = 1;
        for (int i = 1; i < N; i++) {
            output_arr[i] = output_arr[i-1] * nums[i-1];
        }

        // ===============OMIT===============
        // // create right products array
        // int[] right_products = new int[N];
        // right_products[N-1] = 1;
        // for (int i = N-2; i >= 0; i--) {
        //     right_products[i] = right_products[i+1] * nums[i+1];
        // }

        // store right products in temp var
        // compute output
        int R = 1;
        for (int i = N-1; i >= 0; i--) {
            output_arr[i] = output_arr[i] * R;
            R = R * nums[i]; // compute right for next iteration, that's why you don't need to use i+1 elem of nums
        }

        return output_arr;
    }
}