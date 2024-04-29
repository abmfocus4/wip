// https://www.youtube.com/watch?v=qSbJZWENtX4&ab_channel=NickWhite
// lexicographically as in dictionary - check order of words
class Solution {
    int[] char_map;
    public boolean isAlienSorted(String[] words, String order) {
        this.char_map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char_map[order.charAt(i) - 'a'] = i; // map character to index of character
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i-1], words[i]) > 0) { // has to be less than or equal to 0
                return false;
            }
        }
        return true;
    }

    public int compare(String word1, String word2) {
        int compare_val = 0;
        int i = 0;
        int j = 0;
        
        while (i < word1.length() && j < word2.length() && compare_val == 0) {
            compare_val = char_map[word1.charAt(i) - 'a'] - char_map[word2.charAt(j) - 'a'];
            i++;
            j++;
        }

        if (compare_val == 0) { // hell, hello
            return word1.length() - word2.length();
        } else {
            return compare_val;
        }
    }
}