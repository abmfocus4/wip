class Solution {
        public int maxVowels(String s, int k) {
        int ans = 0;
        // Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        var vowels = Set.of('a', 'e', 'i', 'o', 'u'); // Java 11 Collection factory method, credit to @Sithis
        int winCnt = 0;
        int start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++winCnt; 
            }
            if (i-start == k) { // len of substr
                if (vowels.contains(s.charAt(start))) // if contains vowels
                    --winCnt;
                start++; // just pop from start of window
            }
            ans = Math.max(winCnt, ans);
        }
        return ans;
    }
}