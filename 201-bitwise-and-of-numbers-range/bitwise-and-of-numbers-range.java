// https://www.youtube.com/watch?v=3XYQLHSoew8&list=TLPQMDYwNjIwMjTGU_sP9Ubjew&index=3&ab_channel=codestorywithMIK
// set most bit unset
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= (right - 1); // keep unsetting right bits
        }
//TC: number of set bits in right (log n) 
        return right;
    }
}