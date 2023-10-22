// Ref: https://leetcode.com/problems/valid-anagram/solutions/1503603/Java-concise-Single-loop-1-ms-100-beats/
class Solution {
    public boolean isAnagram(String s, String t) {
        // O(n + m + 26)
        // create bucket of 26 chars
        // increment for char - 'a' in s and decrement for char - 'a' in t separately
        // check if bucket values are 0 and return false if they are not

        // O(n+m)
        // create bucket of 26 chars
        // increment bucket for each char in s O(n)
        // decrement bucket for each char of t and check if after decrementing value is less than 0 O(m)
        // return false if it is
        // if exit loop successfully return true

        // O(n + 26)
        // create a bucket of 26 chars
        // increment bucket for each char in s and decrement for each char in t
        // check if buckets are 0

        if (s.length() != t.length()) return false;

        int[] buckets = new int[26]; // only lowercase
        for (int i = 0; i < s.length(); i++) {
            buckets[s.charAt(i) - 'a']++;
            buckets[t.charAt(i) - 'a']--;
        }

        for (int bucket : buckets) {
            if (bucket != 0) return false;
        }

        return true;
    }
}