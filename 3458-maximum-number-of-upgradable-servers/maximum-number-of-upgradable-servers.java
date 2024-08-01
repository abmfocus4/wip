class Solution {
    public int[] maxUpgrades(int[] count, int[] upgrade, int[] sell, int[] money) {
        int n = count.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = getMaxServers(count[i], upgrade[i], sell[i], money[i]);
        }
        return result; 
    }

    private int getMaxServers(int numOfServers, int costOfUpdatingServer, int profitOfSellingServer, int initMoney) {
        // use binary search to find the number of servers we can upgrade
        long left = 0;
        long right = numOfServers;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left)/2;
            // it can be equal or less than the money we can make
            // sell least servers and upgrade most servers
            if (costOfUpdatingServer * mid <= (numOfServers - mid)*profitOfSellingServer + initMoney) {
                ans = mid;
                left = mid + 1; // try upgrading more servers
            } else {
                right = mid - 1; // upgraded too many servers
            }
        }
        return (int)ans;

    }
}