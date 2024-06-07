// https://www.youtube.com/watch?v=PiGYS7BbV_Q&list=TLPQMDYwNjIwMjTGU_sP9Ubjew&index=2&ab_channel=codestorywithMIK
class Solution {
    // TC: kLogK
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // int[0] -> sum and int[1] and int[2] are i and j indexes
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int m = nums1.length;
        int n = nums2.length;

        Set<Pair<Integer, Integer>> visited = new HashSet<>(); // to handle duplicates

        // we know first element will definitely be part of result
        int sum = nums1[0] + nums2[0];
        pq.add(new int[] { sum, 0, 0 });
        visited.add(new Pair(0,0));

        List<List<Integer>> result = new ArrayList<>();

        while (k-- > 0 && !pq.isEmpty()) {
            int[] r = pq.poll();
            int i = r[1];
            int j = r[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < n && !visited.contains(new Pair(i, j + 1) )) {
                sum = nums1[i] + nums2[j + 1];
                pq.add(new int[] { sum, i, j + 1 });
                visited.add(new Pair( i, j + 1));
            }

            if (i + 1 < m && !visited.contains(new Pair(i + 1, j))) {
                sum = nums1[i + 1] + nums2[j];
                pq.add(new int[] { sum, i + 1, j });
                visited.add(new Pair( i + 1, j));
            }
        }
        return result;

    }
}