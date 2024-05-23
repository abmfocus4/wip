class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
       int[] alphabet = new int[26];

        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c - 'a']);
            if (i == -1) {
                return false;
            }
            alphabet[c-'a'] = i + 1;
        }
        return true;
    }
}