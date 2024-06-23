
// https://leetcode.com/problems/ransom-note/solutions/1671552/1ms-100-easy-explanation-java-solution
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) return false;
        int[] alphabets_counter = new int[26];
        
        for (char c : magazine.toCharArray())
            alphabets_counter[c-'a']++;

        for (char c : ransomNote.toCharArray()){
            alphabets_counter[c-'a']--;
            if (alphabets_counter[c-'a'] < 0) return false;

        }
        return true;
    }
}