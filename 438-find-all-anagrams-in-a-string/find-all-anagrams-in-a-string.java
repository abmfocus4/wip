class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // create a freq map for p
        // create a freq map for s substring
        // iterate through s in a sliding window fashion
        // update the s map
        // when end - start + 1 == p.length:
        // compare both maps
        // if equals: add start index to list
        // else: update freq map of s and start++


        int[] pFreqMap = new int[26];
        for (char c : p.toCharArray()) {
            pFreqMap[c - 'a']++;
        }
        int pLen = p.length();
        List<Integer> startIdxList = new ArrayList();

        int[] sFreqMap = new int[26];
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            sFreqMap[s.charAt(end) - 'a']++;
            if (end - start + 1 == pLen) {
                if (Arrays.equals(sFreqMap, pFreqMap)) {
                    startIdxList.add(start);
                }
                sFreqMap[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return startIdxList;
    }
}