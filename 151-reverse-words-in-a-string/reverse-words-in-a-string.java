class Solution {
    public String reverseWords(String s) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack();
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            sb.setLength(0);
            while (i < n && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }

            if (sb.isEmpty() == false) {
                stack.push(sb.toString());
            }
        }

        i = stack.size();
        sb.setLength(0);
        while (i-- > 0) {
            sb.append(stack.pop());
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}