// explanation: https://www.youtube.com/watch?v=f2QgmVxPiS4&ab_channel=codestorywithMIK
// O(1) explanation: https://www.youtube.com/watch?v=ZI2z5pq0TqA&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=8&ab_channel=NeetCode
class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height == null) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        

        return res;
    }
}