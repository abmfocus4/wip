class Solution {
    private static final String[] map = {"",    "",    "abc",  "def", "ghi",
                                                  "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if (digits == null || digits.isEmpty()) return res;
        backtrack(digits, 0, res, new StringBuilder());
        return res;
    }
    
    
    private void backtrack(String digits, int i, List<String> res, StringBuilder sb) {
        
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        for (char c : map[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            backtrack(digits, i + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}