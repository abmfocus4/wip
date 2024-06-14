// explanation : https://www.youtube.com/watch?v=dJ7sWiOoK7g&list=TLPQMDgwNjIwMjTSiTgJSC2Yog&index=3&pp=gAQBiAQB
// explanation II : https://www.youtube.com/watch?v=9kyHYVxL4fw&list=TLPQMDgwNjIwMjTSiTgJSC2Yog&index=4&ab_channel=NikhilLohia
// bfs traversal in O(n) time
class Solution {
    public int jump(int[] nums) {
        int minJumps = 0;

        int left = 0, right = 0;

        while (right < nums.length - 1) {
            int farthestIndex = 0;
            for (int i = left; i <= right; i++) {
                if (i >= nums.length) {
                    break;
                }
                farthestIndex = Math.max(farthestIndex, i + nums[i]);
            }
            left = right + 1;
            right = farthestIndex;
            minJumps += 1; // level traversed
        }

        return minJumps;
    }
}