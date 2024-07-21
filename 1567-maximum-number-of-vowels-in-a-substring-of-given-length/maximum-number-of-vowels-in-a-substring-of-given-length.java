class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
    public int maxVowels(String s, int k) {
        int maxVowels = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;

        int count = 0;

        while (end < s.length()) {
            if (isVowel(s.charAt(end))) {
                count++;
            }

            if (end - start + 1 == k) {
                maxVowels = Math.max(maxVowels, count);
                if (maxVowels == k) {
                    return k;
                }
                if (isVowel(s.charAt(start))) {
                    count--;
                }
                start++;
            }
            end++;
        }

        return maxVowels == Integer.MIN_VALUE ? 0 : maxVowels;
    }
}