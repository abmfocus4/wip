// https://www.youtube.com/watch?v=UPdSViixmDs&ab_channel=NickWhite
class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) { // is neg or ends with 0
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            int right_x = x % 10;
            x = x / 10; // remove last digit from x
            reversed = reversed*10 + right_x;
        }

        if (reversed == x || reversed/10 == x) { // even and odd palindrom num case respectively
            return true;
        } else {
            return false;
        }
    }
}