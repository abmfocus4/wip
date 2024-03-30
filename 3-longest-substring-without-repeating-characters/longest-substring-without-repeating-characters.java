// https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/3649636/3-method-s-c-java-python-beginner-friendly

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window
        // start gets modified with hashmap
        // key = char, value = next index to skip to
        // inside loop, update substr len

        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end)) && start < map.get(s.charAt(end))) {
                start = map.get(s.charAt(end));
            }
            maxLength = Math.max(maxLength, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return maxLength;
    }
}