class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        // map to keep track of char and next index to update start to

        int maxSubstrLen = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) > start) {
                start = map.get(s.charAt(end));
            }
            map.put(s.charAt(end), end+1);
            maxSubstrLen = Math.max(maxSubstrLen, end - start + 1);
        }

        return maxSubstrLen;
    }
}