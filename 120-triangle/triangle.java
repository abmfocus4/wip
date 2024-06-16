// https://www.youtube.com/watch?v=OM1MTokvxs4&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=7&ab_channel=NeetCode
// O(n) space
// O(n^2) time
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> curLevel = triangle.get(i);
            List<Integer> nextRow = triangle.get(i + 1);
            for (int j = 0; j < curLevel.size(); j++) {
                int minSum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + curLevel.get(j);
                curLevel.set(j, minSum);
            }
        }
        return triangle.get(0).get(0);
    }
}

// without extra space by modifying the input

// public int minimumTotal(List<List<Integer>> triangle) {
// if(triangle.size() == 0)
// return 0;

// for (int i=triangle.size() - 2; i>=0; i--) {
// List<Integer> curLevel = triangle.get(i);
// List<Integer> nextRow = triangle.get(i+1);
// for (int j=0; j<curLevel.size(); j++) {
// int minSum = Math.min(nextRow.get(j), nextRow.get(j+1)) + curLevel.get(j);
// curLevel.set(j, minSum);
// }
// }
// return triangle.get(0).get(0);
// }