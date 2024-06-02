// https://www.youtube.com/watch?v=BM-bu4tJz7U&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=6&ab_channel=codestorywithMIK
class Solution {

    private int Operator(String op, int a, int b) {
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else if (op.equals("*")) {
            return a * b;
        } else if (op.equals("/")) {
            return (a / b);
        }

        return -1;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("*") || token.equals("-") ||
                    token.equals("/")) {

                // pop b and then a (not a and b since div is not reflective)
                int b = stack.pop();
                int a = stack.pop();
                int result = Operator(token, a, b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token)); // convert to int
            }
        }

        return stack.pop();
    }
}