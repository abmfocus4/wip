 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findLeftOrRightMost(nums, target, 0), findLeftOrRightMost(nums, target, 1)};
    }

    int findLeftOrRightMost(int[] nums, int t, int flag){
        int ans = -1;

        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] > t){
                r = mid-1;
            }
            else if(nums[mid] < t){
                l = mid+1;
            }
            else{
                ans = mid;
                if(flag == 0) r = mid-1;
                else l = mid+1;
            }
        }

        return ans;
    }
}

