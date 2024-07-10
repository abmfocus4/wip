class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack();
        for (String word : s.trim().split(" ")) {
            if (word.isEmpty() == false)
                stack.push(word);
        }

        int i = stack.size();
        StringBuilder sb = new StringBuilder();
        while (i-- > 0) {
            sb.append(stack.pop());
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}