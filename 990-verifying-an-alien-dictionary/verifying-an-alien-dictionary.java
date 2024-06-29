class Solution {
    int[] index_map;
    public boolean isAlienSorted(String[] words, String order) {
        this.index_map = new int[26];

        for (int i = 0; i < order.length(); i++) {
            index_map[order.charAt(i) - 'a'] = i; 
        }

        for (int i = 1; i < words.length; i++) {
            if (diff(words[i - 1], words[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    private int diff(String word1, String word2) {
        int i = 0;
        int j = 0;

        int diff = 0;

        while (i < word1.length() && j < word2.length() && diff == 0) {
            diff = index_map[word1.charAt(i) - 'a'] - index_map[word2.charAt(i) - 'a'];
            i++;
            j++;
        }

        if (diff == 0) {
            return word1.length() - word2.length();
        } else {
            return diff;
        }
    }
}