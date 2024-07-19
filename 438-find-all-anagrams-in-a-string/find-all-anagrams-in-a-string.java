class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int pLen = p.length();
        int[] pMap = new int[26];
        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }

        int sLen = s.length();
        int start = 0;
        int[] sMap = new int[26];
        for (int end = 0; end < sLen; end++) {
            sMap[s.charAt(end) - 'a']++;
            if (end - start + 1 == pLen) {
                if (Arrays.equals(sMap, pMap)) {
                    res.add(start);
                }
                sMap[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return res;
    }
}