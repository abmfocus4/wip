class Solution {
    public String minWindow(String s, String t) {
        // frequency map
        // start, count, minLength, minStart

        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        HashMap<Character, Integer> map = new HashMap();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int start = 0;
        int count = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) >= 0)
                    count++; // err
            }

            while (count == t.length()) {
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    minStart = start;
                }

                if (map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if (map.get(s.charAt(start)) > 0)
                        count--;
                }
                start++;
            }
        }

        if (s.length() < minLength) //err
            return "";
        return s.substring(minStart, minStart + minLength);

    }
}