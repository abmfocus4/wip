// https://leetcode.com/problems/letter-combinations-of-a-phone-number/solutions/3855474/100-backtracking-iterative-video-letter-combinations-of-a-phone-number
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList();
        List<String> combos = new ArrayList();
        String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        backtrack(digits.toCharArray(), map, combos, "");
        return combos;
    }

    public void backtrack(char[] digits, String[] map, List<String> combos, String temp_combo) {
        if (temp_combo.length() == digits.length) {
            combos.add(temp_combo);
            return;
        }
        int digit = digits[temp_combo.length()] - '0';
        for (char letter : map[digit].toCharArray()) {
            backtrack(digits, map, combos, temp_combo + Character.toString(letter));
        }
    }
}