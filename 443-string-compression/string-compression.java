// https://www.youtube.com/watch?v=IhJgguNiYYk&ab_channel=KevinNaughtonJr.
class Solution {
    public int compress(char[] chars) {
        int ans_index = 0;
        int i = 0;
        int j = 0;
        while (i < chars.length) {
            j = i;
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            chars[ans_index] = chars[i];
            ans_index++;
            if ((j-i) > 1) {
                String count = j - i + "";
                for (char num : count.toCharArray()) {
                    chars[ans_index] = num;
                    ans_index++;
                }
            }
            i = j;
        }
        return ans_index;
    }
}