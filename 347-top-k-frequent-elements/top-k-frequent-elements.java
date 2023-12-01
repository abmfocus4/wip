// what elements are repeated the most and top k out of those
// https://www.youtube.com/watch?v=a3vb_SQVQBo

// Time Complexity: O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create hm of num and freq
        // create hm of freq and list of nums with same freq
        // inter N times to get the top k elems

        Map<Integer, Integer> freqHM = new HashMap<>();
        for (int num : nums) {
            freqHM.put(num, freqHM.getOrDefault(num, 0) + 1);
        }

        Map<Integer, ArrayList<Integer>> numListHM = new HashMap();
        for (int num : freqHM.keySet()) {
            int newListHMKey = freqHM.get(num);
            if (!numListHM.containsKey(newListHMKey))
                numListHM.put(newListHMKey, new ArrayList<>());
            numListHM.get(newListHMKey).add(num);
        }

        int[] res = new int[k];
        int N = nums.length;
        int index = 0;
        for (int i = N; i > 0; i--) {
            if (numListHM.containsKey(i)) {
                ArrayList<Integer> list = numListHM.get(i);
                for (int listElem : list) {
                    res[--k] = listElem;
                    if (k == 0) return res;
                }
            }
        }
        return res;
    }
}