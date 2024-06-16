// O(n) space - brute force
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n]; // l2r and r2l count store
        Arrays.fill(count, 1);

        // move l2r and find candies
        for (int i = 1; i < n; i++)  {
            if (ratings[i] > ratings[i-1]) {
                // should have more candies
                count[i] = Math.max(count[i], count[i-1] + 1); // more than the neighbour with low ratings
            }
        }

        /// move r2l and store candies
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                // should have more candies
                count[i] = Math.max(count[i], count[i+1] + 1); // more than the neighbour with low ratings
            }
        }

        return Arrays.stream(count).sum();
    }
}