// follow up - https://leetcode.com/problems/is-subsequence/solutions/87302/binary-search-solution-for-follow-up-with-detailed-comments
class Solution {
    public boolean isSubsequence(String s, String t) {
        // create 'character' -> index list map
        HashMap<Character, List<Integer>> index_map = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (index_map.containsKey(c) == false) {
                index_map.put(c, new ArrayList());
            }
            index_map.get(c).add(i);
        }
        // iterate through s, and find next index of prevIndex selected through binary search for the current character
        int prevIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index_map.containsKey(c) == false)  return false;
            List<Integer> indexList = index_map.get(c);
            int j = Collections.binarySearch(indexList, prevIndex);

            if (j < 0) {
                j = - j - 1; // insertion point of binary search method
            }

            if (j == indexList.size()) { // matching index does not exist
                return false;
            }

            prevIndex = indexList.get(j) + 1; // min next index to find (strictly greater subsequence)
        }

        return true;
    }
}