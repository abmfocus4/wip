// https://leetcode.com/problems/reverse-vowels-of-a-string/solutions/3723102/easy-solution-with-simple-explanation-using-two-pointer

// use hashset or string of vowels with indexOf and equal to -1
// indexOf runs in linear time
class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        // String vowels = "aeiouAEIOU";
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));        

        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.contains(word[start]) == false) {
            // while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }
            
            // Move end pointer until it points to a vowel
            while (start < end && vowels.contains(word[end]) == false) {
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
}