// editor: using bitsets
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < (int)Math.pow(2, n); ++i) {
            // fixed size bitset
            // remove leading 1
            // nums = [1, 2, 3] and i = 8, the binary representation is 1000, we want 000
            String bitset = Integer.toBinaryString(i | (1<<n)).substring(1);
            List<Integer> subset = new ArrayList();
            for (int j = 0; j < bitset.length(); ++j) {
                if (bitset.charAt(j) == '1') {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}