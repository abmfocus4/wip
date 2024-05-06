class Solution {
    public String decodeString(String s) {
        Queue<Character> q = new LinkedList();
        for (char c : s.toCharArray())  q.add(c);
        return helper(q);
    }

    public String helper(Queue<Character> q) {
        int num = 0;
        StringBuilder sb = new StringBuilder();

        while (q.isEmpty() == false) {
            char c = q.poll(); // current character
            if (Character.isDigit(c)) { // k case
                num = (num*10) + (c - '0');
            } else if (c == '[') { // sub problem
                String str = helper(q);
                for (int i = 0; i < num; i++) {
                    sb.append(str);
                }
                num = 0;
            } else if (c == ']') { // end case
                break;
            } else { // char case
                sb.append(c);
            }
        }

        return sb.toString();
    }
}