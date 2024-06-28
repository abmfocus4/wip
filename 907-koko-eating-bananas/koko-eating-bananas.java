class Solution {
    int[] piles;
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles;
        
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left <= right) {
            int mid = left + ((right - left)/2);
            long midHours = hoursTaken(mid);
            if (midHours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long hoursTaken(int k) {
        long totalHours = 0;
        for (int pile : piles) {
            totalHours += pile/k;
            if (pile%k != 0) {
                totalHours++;
            }
        }
        return totalHours;
    }
}