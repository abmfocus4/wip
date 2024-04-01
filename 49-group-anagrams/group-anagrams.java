// https://leetcode.com/problems/group-anagrams/solutions/19176/share-my-short-java-solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] frequencyStr = new char[26];
            for (char c : str.toCharArray()) {
                frequencyStr[c-'a']++;
            }
            String keyStr = String.valueOf(frequencyStr);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList());
            }

            map.get(keyStr).add(str);
        }
        return new ArrayList(map.values());
    }
}