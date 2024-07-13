class Solution {
    public boolean wordPattern(String pattern, String str) {        
        String[] words = str.split(" ");
        
        if (pattern.length() != words.length) return false;

        Map<Character, String> letterToWord = new HashMap<>(words.length);
        Map<String, Character> wordToLetter = new HashMap<>(words.length);

        for (int i = 0; i < words.length; ++i) {
            char letter = pattern.charAt(i);
            String word = words[i];

            // case 1: one letter maps to different word
            if (letterToWord.containsKey(letter) && !letterToWord.get(letter).equals(word))
                return false;

            // case 2: one word maps to different letter
            if (wordToLetter.containsKey(word) && wordToLetter.get(word) != letter)
                return false;

            letterToWord.put(letter, word);
            wordToLetter.put(word, letter);
        }

        return true;
    }
}