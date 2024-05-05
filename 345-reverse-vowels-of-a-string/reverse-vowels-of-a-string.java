class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;       

        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && isVowel(word[start]) == false) {
                start++;
            }
            
            // Move end pointer until it points to a vowel
            while (start < end && isVowel(word[end]) == false) {
                end--;
            }
            
            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            
            // Move the pointers towards each other
            start++;
            end--;
        }
        
        return new String(word);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
            || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}