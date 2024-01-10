//Ref/Comments:https://leetcode.com/problems/longest-repeating-character-replacement/solutions/2524523/easy-100-fully-explained-c-java-python-javascript-python3-sliding-window/?envType=list&envId=pxw54vnt
//Ref Video:https://www.youtube.com/watch?v=00FmUN1pkGE&ab_channel=NickWhite
class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int[] count_arr = new int[26];
        int window_start = 0, largestCount = 0, maxLen = 0;
        
        for(int window_end = 0; window_end < N; window_end++) {
            count_arr[s.charAt(window_end)-'A']++;
            largestCount = Math.max(largestCount, count_arr[s.charAt(window_end)-'A']);

            if (window_end - window_start + 1 - largestCount > k) {
                count_arr[s.charAt(window_start)-'A']--;
                window_start++;
            }

            maxLen = Math.max(maxLen, window_end - window_start + 1);
        }
        return maxLen;
    }
}