// https://www.youtube.com/watch?v=taYRJf-M25I&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=10&ab_channel=Techdose - not that good explanation but okay
class Solution {
        int wordLen;
        Map<String, Integer> counts;

        public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        // create frequency map for words
        counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        
        List<Integer> r = new ArrayList<>();

        int sLen = s.length();
        int n = words.length;
        
        wordLen = words[0].length(); // word len is same
        int concatStrLen = n * wordLen;

        for (int i = 0; i <= sLen - concatStrLen; i++) { // starting window index
            String sub = s.substring(i, i + concatStrLen);
            if (isConcat(sub)) {
                r.add(i); // starting index of concat string
            }
        }
        return r;
    }
    
    /**
     * */
    private boolean isConcat(String str) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i < str.length(); i += wordLen) { // create map of seens string so far
            String subWord = str.substring(i, i + wordLen);
            seen.put(subWord, seen.getOrDefault(subWord, 0) + 1);
        }
        return seen.equals(counts); // comparing hash maps
    }
}