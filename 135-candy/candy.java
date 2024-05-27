// https://www.youtube.com/watch?v=YUT13Koh5Jg&ab_channel=codestorywithMIK
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int totalCandy = n; // each child atleast 1 candy

        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i-1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (ratings[i] > ratings[i-1]) {
                peak++;
                totalCandy += peak; // increment after increasing peak
                i++;
                if (i == n) {
                    return totalCandy;
                }
            }

            int dip = 0;
            while (i < n && ratings[i] < ratings[i-1]) {
                dip++;
                totalCandy += dip;
                i++;
            }

            totalCandy -= Math.min(dip, peak);
            // after one mountain cross, take only max of peak and dip
            // so remove min from totalCandy
        }

        return totalCandy;
    }
}