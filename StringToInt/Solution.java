// https://www.youtube.com/watch?v=lJy5GhKYHl0

class Solution {
    public int myAtoi(String str) {
        //params checking
        if (str == null || str.length == 0) {
            return 0;
        }
        
        double result = 0;

        // whitespace case
        str = str.trim();

        // handle negative
        boolean isNegative = false;
        int startIndex = 0;

        if (str.charAt(startIndex) == '+' || str.charAt(startIndex) == '-') {
            startIndex++;
        }

        if (str.charAt(startIndex) == '-') {
            isNegative = true;
        }

        for (int i = startIndex; i<str.length(); i++){
            // handle extra chars case
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            // normal case
            int digitValue = (int)(str.charAt(i) - '0'); // '9' - '0'
            result = (result * 10) + digitValue;
        }

        if (isNegative) {
            result = -1 * result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)result;
    }
}