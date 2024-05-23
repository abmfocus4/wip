class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char curChar = s.charAt(i);
            if (curChar != ' ') {
                length++;
            } else {
                if (length > 0) return length; 
                // account for empty spaces at the end of the word
            }
        }
        return length;
    }
}