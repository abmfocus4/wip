// finding longest common prefix
// https://www.youtube.com/watch?v=3XYQLHSoew8&list=TLPQMDYwNjIwMjTGU_sP9Ubjew&index=3&ab_channel=codestorywithMIK
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftRightCount = 0;

        while(left != right) {
            left >>= 1;
            right >>= 1;
            shiftRightCount++;
        }

        return left << shiftRightCount;
    }
}