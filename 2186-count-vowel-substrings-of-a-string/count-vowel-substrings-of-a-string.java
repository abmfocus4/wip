class Solution {
    public int countVowelSubstrings(String word) {
        // let window_start - start + 1 be how many subarrays starts are there, such that [subArrStart: window_end] satisfies the criteria.
        int start = 0;
        int window_start = 0;
        int uniqueVowels = 0;
        int[] charCount = new int[26];
        int ans = 0;
        
        for(int window_end = 0; window_end < word.length(); window_end++){
            // If it's a vowel, we continue the expansion
            if(isVowel(word.charAt(window_end))){
                charCount[word.charAt(window_end) - 'a']++;
                if(charCount[word.charAt(window_end) - 'a'] == 1) uniqueVowels++;
                
                while(uniqueVowels == 5){
                    charCount[word.charAt(window_start) - 'a']--;
                    if(charCount[word.charAt(window_start) - 'a'] == 0) uniqueVowels--;
                    window_start++;
                }
                
                // window_start - 1 because window_start was incremented by 1 in the while loop
                ans += (window_start - 1) - start + 1;
            } 
            // If it's not a vowel, collapse the window and restart
            else {
                start = window_end + 1;
                window_start = start;
                uniqueVowels = 0;
                charCount = new int[26];
            }
        }
        return ans;
    }
    private boolean isVowel(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}