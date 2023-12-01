// what elements are repeated the most and top k out of those
// https://www.youtube.com/watch?v=a3vb_SQVQBo

// First Sol: O(nLogk)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // first create hash table with elem as key and freq as value
        // create min heap sorted by freq
        // insert elements one by one
        // if size of heap exceeds over k then remove min freq elem
        // insert all elems in heap into res arr
        

        Map<Integer, Integer> hm = new HashMap();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> q = new PriorityQueue<>((a,b) -> hm.get(a) - hm.get(b));

        for (int num : hm.keySet()) {
            q.add(num);
            if (q.size() > k) {
                q.poll();
            }
        }

        int[] res = new int[k];
        int index = 0;
        while(q.isEmpty() == false) {
            res[index++] = q.poll();
        }

        return res;

    }
}