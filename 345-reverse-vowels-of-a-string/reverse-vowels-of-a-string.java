class Solution {
    public String reverseVowels(String s) {
        char[] s_arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && isVowel(s_arr[start]) == false) {
                start++;
            }

            while (start < end && isVowel(s_arr[end]) == false) {
                end--;
            }

            char temp = s_arr[start];
            s_arr[start] = s_arr[end];
            s_arr[end] = temp;

            start++;
            end--;
        }

        return new String(s_arr);
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || 
                c == 'O' || c == 'u' || c == 'U');
    }
}