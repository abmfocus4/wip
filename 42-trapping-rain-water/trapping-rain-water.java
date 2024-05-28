// explanation: https://www.youtube.com/watch?v=f2QgmVxPiS4&ab_channel=codestorywithMIK
// O(1) explanation: https://www.youtube.com/watch?v=ZI2z5pq0TqA&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=8&ab_channel=NeetCode
class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height == null) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int left_max = height[left];
        int right_max = height[right];

        int res = 0;
        while (left < right) {
            if (left_max < right_max) {
                left++;
                left_max = Math.max(left_max, height[left]);
                res += left_max - height[left];

            } else {
                right--;
                right_max = Math.max(right_max, height[right]);
                res += right_max - height[right];
            }
        }

        return res;
    }
}