class Solution {
    int[] memo;
    int[] startTimeArr;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { startTime[i], endTime[i], profit[i] };
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        this.memo = new int[n];
        Arrays.fill(memo, -1);

        this.startTimeArr = new int[n];
        for (int i = 0; i < n; i++) {
            startTimeArr[i] = jobs[i][0];
        }

        return maxProfit(jobs, 0);
    }

    private int maxProfit(int[][] jobs, int curIdx) {
        int n = jobs.length;
        if (curIdx == n) {
            return 0;
        }

        if (memo[curIdx] != -1) {
            return memo[curIdx];
        }

        int take = jobs[curIdx][2] + maxProfit(jobs, binarySearch(jobs[curIdx][1], startTimeArr));
        int notTake = 0 + maxProfit(jobs, curIdx + 1);
        int maxProfit = Math.max(take, notTake);

        return memo[curIdx] = maxProfit;
    }

    private int binarySearch(int target, int[] arr) { // get greater than or equal end time
        int left = 0;
        int right = arr.length - 1;

        int ans = arr.length; // max value as default

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) { // start or greater than start
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}