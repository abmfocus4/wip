class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList();
        char[] parenthesis = new char[n*2];
        generateParenthesis(n, n, 0, parenthesis);
        return res;
        // if there are left rem
        // if the left at most right
    }

    private void generateParenthesis(int leftRem, int rightRem, int index, char[] parenthesis) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }

        if (leftRem == 0 && rightRem == 0) {
            res.add(new String(parenthesis));
        } else {
            parenthesis[index] = '(';
            generateParenthesis(leftRem - 1, rightRem, index+1, parenthesis);

            parenthesis[index] = ')';
            generateParenthesis(leftRem, rightRem - 1, index+1, parenthesis);
        }
        
    }
}