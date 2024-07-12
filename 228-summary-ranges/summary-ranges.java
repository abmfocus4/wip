class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (i + 1 < n && nums[i] + 1 == nums[i+1]) {
                end++;
                i++;
            }

            if (start == end) {
                result.add(String.valueOf(nums[start]));
            } else {
                sb.append(String.valueOf(nums[start])).append("->").append(String.valueOf(nums[end]));
                result.add(sb.toString());
                sb.setLength(0);
            }

            end++;
            start = end;
        }

        return result;
    }
}