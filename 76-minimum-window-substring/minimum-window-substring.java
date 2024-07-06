class Solution {
    // Sliding Window problem
    // Time: O(N+N+M) or Time: O(N+M) 
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) return "";
        
        // create map for t str
        // Space: O(M)
        HashMap<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        int count = 0; // window eligibility check
        int start = 0; // left boundary pointer

        // store result
        int minLength = Integer.MAX_VALUE; // best smallest substring size
        int minLeft = 0; // best left boundary

        for (int i = 0; i < s.length(); i++) { // right boundary managed by loop
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if (map.get(s.charAt(i)) >= 0) count++;
            }

            while (count == t.length()) { // found eligible window
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    minLeft = start;
                }

                if (map.containsKey(s.charAt(start))) { // shrink window
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    if (map.get(s.charAt(start)) > 0) count--;
                }
                start++;
            }
        }

        if (minLength > s.length()) return "";
        return s.substring(minLeft, minLeft + minLength);
    }
}