class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1) == false) {
            return "";
        }

        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    public int getGcd(int p, int q) {
        if (q == 0) return p;
        return getGcd(q, p % q);
    }
}