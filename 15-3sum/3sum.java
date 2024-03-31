class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        Set<List<Integer>> set = new HashSet();
        Arrays.sort(nums);
        int low, high, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // if (i == 0  || i > 0 && nums[i] != nums[i-1])
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
            sum = nums[i] + nums[low] + nums[high];
            if (sum == 0) {
                set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                low++;
                high--;
            } else if (sum < 0) {
                low++;
            } else if (sum > 0) {
                high--;
            }}
        }
        return new ArrayList(set);
    }
}