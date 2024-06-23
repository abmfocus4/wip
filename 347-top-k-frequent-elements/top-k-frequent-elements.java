class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create freq map
        // sort frequencies in pq min
        // pop k elems in pq

        // create freq map
        // reverse index  - key == freq && value == list of elems
        // iterate from k to 0 and exit at 0 and keep adding elems to return

        HashMap<Integer, Integer> numFreqMap = new HashMap();
        for (int num : nums) {
            numFreqMap.put(num, numFreqMap.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, List<Integer>> freqNumMap = new HashMap();
        for (int num : numFreqMap.keySet()) {
            int freq = numFreqMap.get(num);
            if (freqNumMap.containsKey(freq) == false) {
                freqNumMap.put(freq, new ArrayList());
            }
            freqNumMap.get(freq).add(num);
        }

        int[] result = new int[k];
        for (int i = nums.length; i >= 0; i--)
        {
            if (freqNumMap.containsKey(i)) {
                List<Integer> list = freqNumMap.get(i);
                for (int j = 0; j < list.size(); j++) {
                    result[--k] = list.get(j);
                    if (k == 0) return result;
                }
                
            }
            
        }

        return result;
    }
}