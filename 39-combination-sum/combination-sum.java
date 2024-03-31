// backtracking (recursion) problem - searching for all possible solutions
// Time = O(N^target)
// https://leetcode.com/problems/combination-sum/description/comments/1568512
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        // 0 is starting index
        backtrack(candidates, target, result, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> result, int start, List<Integer> list) {
        // positive case
        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        // backtracking trigger
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) return;
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, i, list);
            // returned after trying to backtrack
            list.remove(list.size() - 1);
        }
    }
}