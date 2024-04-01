// https://leetcode.com/problems/group-anagrams/solutions/19176/share-my-short-java-solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String strSorted = String.valueOf(strArr);
            if (!map.containsKey(strSorted)) {
                map.put(strSorted, new ArrayList());
            }
            map.get(strSorted).add(str);
        }
        return new ArrayList(map.values());
    }
}