class Solution {
    public int mySqrt(int x) {
        int left = 1;
// sqrt(x) = x / 2  ->  x = x*x/4  ->  x=4 or x=0,
// when 0 < x < 4, sqrt(x) > x/2;
// when x > 4, sqrt(x) < x/2;
        int right = (x < 4) ? x : x/2;


        while (left <= right) {
            int mid = left + (right - left)/2;
            if (mid == x/mid) {
                return mid;
            } else if (mid < x/mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right; // round down
    }
}