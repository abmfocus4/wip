// https://www.youtube.com/watch?v=XYi2-LPrwm4&ab_channel=NeetCode
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] ops = new int[m+1][n+1];

        // if one of the words in empty, then ops is number of chars in non empty string
        for (int i = 0; i <= m; i++) {
            ops[i][n] = m-i;
        }

        for (int i = 0; i <= n; i++) {
            ops[m][i] = n-i;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    ops[i][j] = ops[i+1][j+1];
                } else {
                    int replace = ops[i+1][j+1];
                    int insert = ops[i][j+1];
                    int delete = ops[i+1][j];
                    ops[i][j] = 1 + Math.min(replace, Math.min(insert, delete)); // min of all 3 ops
                }
            }
        }
        return ops[0][0];
    }
}