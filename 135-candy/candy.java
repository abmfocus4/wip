class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int total = n;
        int i = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (ratings[i] > ratings[i - 1]) {
                peak++;
                total += peak;
                i++;
                if (i == n) {
                    return total;
                }
            }

            int dip = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                dip++;
                total += dip;
                i++;
            }

            total -= Math.min(dip, peak);
        }
        return total;
    }
}