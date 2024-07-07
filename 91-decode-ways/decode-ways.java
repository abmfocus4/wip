class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int count_prev = 1, count_prev_prev = 1;

        for (int i = 1; i < s.length(); i++) {
            int d = s.charAt(i) - '0';
            int dd = (s.charAt(i-1) - '0')*10 + d;
            int count = 0;
            if (d > 0) {
                count += count_prev;
            }
            if (dd >= 10 && dd <= 26) {
                count += count_prev_prev;
            }

            count_prev_prev = count_prev;
            count_prev = count;
        }

        return count_prev;
    }
}