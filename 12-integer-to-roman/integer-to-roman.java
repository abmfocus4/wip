// https://www.youtube.com/watch?v=2FPvU8XmsKU&ab_channel=codestorywithMIK
class Solution {
    static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < romans.length; i++) {
            int times = num/values[i];
            while (times-- > 0) {
                sb.append(romans[i]);
            }
            num = num%values[i];
        }

        return sb.toString();
    }
}