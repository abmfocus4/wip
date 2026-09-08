// Key Adaptations for Unicode
// Use a Hash Map: Map each character (or code point) to its frequency count.

// Handle Multi-Byte Code Points (Surrogate Pairs): In languages like Java or C#, standard char types are 16-bit UTF-16 code units. Characters outside the Basic Multilingual Plane (BMP), such as emojis, occupy two chars (a surrogate pair). Iterating over code points (s.codePoints()) ensures these characters are counted as a single unit rather than split into invalid pieces.



import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths (measured in code points) differ, they can't be anagrams
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length())) {
            return false;
        }

        Map<Integer, Integer> counts = new HashMap<>();

        // Increment count for characters in string s
        s.codePoints().forEach(codePoint -> 
            counts.put(codePoint, counts.getOrDefault(codePoint, 0) + 1)
        );

        // Decrement count for characters in string t
        for (int codePoint : (Iterable<Integer>) t.codePoints()::iterator) {
            int currentCount = counts.getOrDefault(codePoint, 0);
            if (currentCount == 0) {
                return false; // Character not found or used more times than in 's'
            }
            counts.put(codePoint, currentCount - 1);
        }

        return true;
    }
}