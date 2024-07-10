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
            if (sb.length() > 0) {
                stack.add(sb.toString());
            }
        }

        sb.setLength(0);
        i = stack.size();
        while (i-- > 0) {
            sb.append(stack.pop());
            if (i != 0) {
                sb.append(" ");
            }
            
        }
        return sb.toString();
    }
}