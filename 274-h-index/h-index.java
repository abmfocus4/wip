// https://www.youtube.com/watch?v=zzTUtpBQh4k&ab_channel=KnowledgeCenter
// Counting sort puts the number of occurrences (an integer) in buckets. Each bucket doesn't need to be sorted further.
class Solution {
    public int hIndex(int[] citations) {
        // TC, SC = O(N)
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) { // SCAN FROM BACK BECAUSE WE ARE TRYING TO FIND LARGEST
            count += buckets[i];
            if (count >= i) { // num citations larger than papers
                return i;
            }
        }
        return 0;
    }
}
