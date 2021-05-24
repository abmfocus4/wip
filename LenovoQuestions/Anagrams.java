// https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem

// the template for sliding window algorigthm
public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char c = s.charAt(end);//get a character
            
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;
            
            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                begin++;
            }
        }
        return result;
    }
}
// Given two strings s and t of lengths m and n respectively, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
// Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.

public class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
            
        }
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}

//Longest Substring with At Most Two Distinct Characters
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, len = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) == 1) counter++;//new char
            end++;
            while(counter > 2){
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if(map.get(cTemp) == 0){
                    counter--;
                }
                start++;
            }
            len = Math.max(len, end-start);
        }
        return len;
    }
}

//Substring with Concatenation of All Words
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new LinkedList<>();
        if (L.length == 0 || S.length() < L.length * L[0].length())   return res;
        int N = S.length();
        int M = L.length; // *** length
        int wl = L[0].length();
        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
        for (String s : L) {
            if (map.containsKey(s))   map.put(s, map.get(s) + 1);
            else                      map.put(s, 1);
        }
        String str = null, tmp = null;
        for (int i = 0; i < wl; i++) {
            int count = 0;  // remark: reset count 
            int start = i;
            for (int r = i; r + wl <= N; r += wl) {
                str = S.substring(r, r + wl);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str))   curMap.put(str, curMap.get(str) + 1);
                    else                           curMap.put(str, 1);
                    
                    if (curMap.get(str) <= map.get(str))    count++;
                    while (curMap.get(str) > map.get(str)) {
                        tmp = S.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;
                        
                        //the same as https://leetcode.com/problems/longest-substring-without-repeating-characters/
                        if (curMap.get(tmp) < map.get(tmp)) count--;
                        
                    }
                    if (count == M) {
                        res.add(start);
                        tmp = S.substring(start, start + wl);
                        curMap.put(tmp, curMap.get(tmp) - 1);
                        start += wl;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    start = r + wl;//not contain, so move the start
                }
            }
            curMap.clear();
        }
        return res;
    }
}

//Find All Anagrams in a String
public class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
}

//Longest Substring with At Most K Distinct Characters
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.isEmpty()) return 0;
    int maxLen = 0, left = 0, right = 0, counter = 0;
    Map<Character, Integer> map = new HashMap<>();
    while(right < s.length()) {
        char ch = s.charAt(right++);
        map.put(ch, map.getOrDefault(ch, 0) + 1);
        if (map.size() > k) counter++;
        while(counter > 0) {
            char tmp = s.charAt(left);
            map.put(tmp, map.get(tmp) - 1);
            if (map.get(tmp) == 0) {
                map.remove(tmp);
                counter--;
            }
            left++;
        }
        maxLen = Math.max(maxLen, right - left);
        
    }
    return maxLen;        
}