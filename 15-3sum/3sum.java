class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        int low, high, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i-1]) {
                low = i + 1;
                high = nums.length - 1;
                while (low < high) {
                sum = nums[i] + nums[high] + nums[low];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low+1]) low++;
                    while (low < high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                } else if (sum < 0) {
                    low++;
                } else if (sum > 0) {
                    high--;
                }}
            }
        }

        return list;
    }
}