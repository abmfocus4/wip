class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pMap = new int[26];
        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }
        int[] sMap = new int[26];
        int start = 0;
        List<Integer> result = new ArrayList();
        // compare arrays of smap and pmap when count == p.length()
        // append to list
        for (int end = 0; end < s.length(); end++) 
        {
            sMap[s.charAt(end) - 'a']++;
            if (end - start + 1 == p.length()) {
               if (Arrays.equals(sMap, pMap)) {
                    result.add(start);
               }
               sMap[s.charAt(start)-'a']--;
               start++;
            }
        }

        return result;
    }

}