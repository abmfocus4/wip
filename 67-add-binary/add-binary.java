class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aPos = a.length() - 1, bPos = b.length() - 1, carry = 0;;
        int aVal = 0, bVal = 0;
        while (aPos >= 0 || bPos >= 0 || carry == 1) {
            aVal = (aPos >= 0) ? a.charAt(aPos--) - '0' : 0;
            bVal = (bPos >= 0) ? b.charAt(bPos--) - '0' : 0;
            sb.append(aVal ^ bVal ^ carry);
            carry = (aVal & bVal) | (aVal & carry) | (bVal & carry);
        }

        return sb.reverse().toString();
    }
}