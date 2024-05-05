class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char[] str = s.toCharArray();
        while (i < s.length()) {
            while(i < s.length() && str[i] == ' ') i++;
            sb.setLength(0);
            while (i < s.length() && str[i] != ' ') {
                sb.append(str[i]);
                i++;
            }
            stack.add(sb.toString());
        }
        sb.setLength(0);
        while (stack.isEmpty() == false) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}