class Solution {
        public int maxVowels(String s, int k) {
            // substring of len k
            int maxVowels = 0;
            int start = 0;
            int vowelsCnt = 0;
            for (int end = 0; end < s.length(); end++) {
                if (isVowel(s.charAt(end))) {
                    vowelsCnt++;
                }

                if (end - start + 1 == k) {
                    maxVowels = Math.max(vowelsCnt, maxVowels);
                    if (maxVowels == k) break;
                    if (isVowel(s.charAt(start))) {
                        vowelsCnt--;
                    }
                    start++;
                }

            }

            return maxVowels;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}