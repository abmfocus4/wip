class Solution {
// https://leetcode.com/problems/permutations/solutions/18239/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums); // needed?
        generateSubsets(nums, 0, new ArrayList(), res);
        return res;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> tempList, List<List<Integer>> res) {
        res.add(new ArrayList(tempList));

        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            generateSubsets(nums, i+1, tempList, res);
            tempList.remove(tempList.size() - 1);
        }
    }
}