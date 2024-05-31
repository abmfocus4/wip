// https://www.youtube.com/watch?v=3AEKyHx3tzU&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=15&ab_channel=codestorywithMIK
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack();

        int result = 0;
        int number = 0;
        int sign = 1; //1 for + and -1 for -

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);

            if (Character.isDigit(cur)) {
                number = (number * 10) + (cur - '0');
            } else if (cur == '+') {
                result += (sign * number);
                number = 0;
                sign = 1;
            } else if (cur == '-') {
                result += (sign * number);
                number = 0;
                sign = -1;
            } else if (cur == '(') {
                result += (sign * number);

                stack.push(result);
                stack.push(sign);

                result = 0;
                number = 0;
                sign = 1;

            } else if (cur == ')') {
                result += (sign * number);

                result *= stack.pop();
                result += stack.pop();

                number = 0;
                sign = 1;
            }
        }

        result += (sign * number);
        return result;
    }
}