class Solution {
    // no look sol
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length() || s.isEmpty() || t.isEmpty()) return "";

        // add t to map
        HashMap<Character, Integer> map = new HashMap<>();
        for (char cur : t.toCharArray()) {
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        int count = 0;
        int start = 0;

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) { // expand window/ check eligibility
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) >= 0) count++;
            }

            while (count == t.length()) {
                // check min window
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    minStart = start;
                }

                char remove_cur = s.charAt(start);
                if (map.containsKey(remove_cur)) {
                    map.put(remove_cur, map.get(remove_cur) + 1);
                    if (map.get(remove_cur) > 0) count--;
                }
                start++;
            }
        }

        if (minLength > s.length()) return "";
        return s.substring(minStart, minStart + minLength);

    }
}