class Solution {

    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        return helper(num);
    }

    private String helper(int num) {
        StringBuilder result = new StringBuilder();
        // if less than 20, won't continue forward 
        // that is how else if's work

        // if less than 20, will just add the word
        if (num < 20) {
            result.append(belowTwenty[num]);

            // if less than 100, will add the tens and below 20 together
        } else if (num < 100) {
            result.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
            // adds Hundred to the word and appends the rest and does it for everything below
        } else if (num < 1000) {
            result.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) { // 6 zeroes
            result.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) { // 9 zeroes
            result.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            result.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }

        // trim elimates all leading whitespaces in the string 
        return result.toString().trim();
    }
} 