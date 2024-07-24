class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> numFreqMap = new HashMap();
        for (int num : nums) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int key : numFreqMap.keySet()) {
            pq.add(numFreqMap.get(key));
        }

        while (pq.size() >= 2) { // long as i can remove pairs
            int first = pq.poll();
            int second = pq.poll();
            if (first - 1 > 0) pq.add(first - 1);
            if (second - 1 > 0) pq.add(second - 1);
        }

        if (pq.isEmpty()) {
            return 0;
        }

        // return max freq element that's at the top because that can't be consumed
        return pq.poll();
    }
}