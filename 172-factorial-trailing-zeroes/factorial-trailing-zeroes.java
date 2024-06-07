// https://www.youtube.com/watch?v=57hXUDXVY8s&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=3&ab_channel=TAPACADEMY
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }
        return count;
    }
}