public class Codec {
    public String encode(List<String> strs) {
        // Initialize a StringBuilder to hold the encoded string.
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            // Append the length, the delimiter, and the string itself.
            encodedString.append(s.length()).append("#").append(s);
        }
        return encodedString.toString();
    }

    public List<String> decode(String s) {
        // Initialize a list to hold the decoded strings.
        List<String> res = new ArrayList<>();
        char[] sArr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (sArr[i] != '#') {
                sb.append(sArr[i++]);
            }
            i++;

            int size = Integer.parseInt(sb.toString());
            sb.setLength(0);
            while(size-- > 0) {
                sb.append(sArr[i++]);
            }
            i--;
            res.add(sb.toString());
        }
        return res;
    }
}