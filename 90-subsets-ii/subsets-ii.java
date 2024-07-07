class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        backtrack(nums, res, new ArrayList(), 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> subset, int start) {
        res.add(new ArrayList(subset));

        for (int i = start; i < nums.length; i++) {
            if (i - 1 >= start && nums[i] == nums[i-1]) continue;
            // if ((i-1 >= start) && nums[i] != nums[i - 1]) {
                subset.add(nums[i]);
                backtrack(nums, res, subset, i + 1);
                subset.remove(subset.size() - 1);
            // }
        }
    }
}