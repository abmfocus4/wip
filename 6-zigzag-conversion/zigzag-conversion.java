// TC: O(n)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows]; // each row is string builder
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();

        int idx = 0;
        int direction = -1;
        char[] chars = s.toCharArray();
        for (char c : chars) { // append row by row
            sbs[idx].append(c);
            if (idx == 0 || idx == numRows - 1) direction = 0 - direction; // hit bottom or top row, change direction
            idx += direction;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : sbs) res.append(sb);    
        return res.toString();
    }
}