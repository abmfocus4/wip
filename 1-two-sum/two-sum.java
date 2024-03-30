class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hash table stores index and element
        // iterate through array
        // check if complement exists in ht
        // if it does then return cur index and output index from ht
        // otherwise put cur index in ht
        // return null if no complement

        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}