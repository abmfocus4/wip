class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack();
        for (String word : s.trim().split(" ")) {
            if (word.isEmpty() == false) {
                stack.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.isEmpty() == false) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}