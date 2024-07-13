class Solution {
    public int hIndex(int[] citations) {
        // 0th paper, 3 citations
        // 1: 0
        // 2: 6 ...
        // i want to know how many papers have x citations
        // create frequency map for citations
        // 0...n

        // num >= i return i;

        // return 0
        int n = citations.length;
        int[] buckets = new int[n+1];
        for (int citation : citations) {
            if (citation >= n) {
                buckets[n]++;
            } else {
                buckets[citation]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += buckets[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }
}