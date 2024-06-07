// https://www.youtube.com/watch?v=eptC4nUL_2A&list=TLPQMDYwNjIwMjTGU_sP9Ubjew&index=1&ab_channel=codestorywithMIK
// TC: O(m*n*logk)
class Solution {
    class PQElement {
        int sum;
        int i;
        int j;

        public PQElement(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList();
        // max heap with sum as first and indexes as second
        PriorityQueue<PQElement> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (pq.size() < k) {
                    pq.add(new PQElement(sum, nums1[i], nums2[j]));
                } else if (pq.peek().sum > sum) {
                    pq.poll();
                    pq.add(new PQElement(sum, nums1[i], nums2[j]));
                } else {
                    break; // coming pairs will be larger because of ascending order
                }
            } 
        }

        while (k-- > 0) {
            var top = pq.poll();
            result.add(List.of(top.i, top.j));
        }

        return result;

        
    }
}