class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList();
        int n = words.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            int lettersSlots = words[i].length();
            int spaceSlots = 0;
            j = i+1;

            while ((j < n) && lettersSlots + spaceSlots + words[j].length() + 1 <= maxWidth) {
                lettersSlots += words[j].length();
                spaceSlots++;
                j++;
            }

            int remainingSlots = maxWidth - lettersSlots;
            int spacesBetweenWords = 0;
            int spacesToDistribute = 0;
            if (j == n) {
                spacesBetweenWords = 1;
                spacesToDistribute = 0;
            } else {
                spacesBetweenWords = spaceSlots == 0 ? 0 : remainingSlots/spaceSlots;
                spacesToDistribute = spaceSlots == 0 ? 0 : remainingSlots%spaceSlots;
            }

            lines.add(getLine(i, j, spacesBetweenWords, spacesToDistribute, words, maxWidth));
            
            i = j;
        }

        return lines;
    }

    private String getLine(int firstIdx, int lastIdx, int spacesBetweenWords, int spacesToDistribute, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int k = firstIdx; k < lastIdx; k++) 
        {
            sb.append(words[k]);

            if (k == lastIdx - 1) {
                break;
            }

            for (int space = 1; space <= spacesBetweenWords; space++) {
                sb.append(" ");
            }

            if (spacesToDistribute > 0) {
                sb.append(" ");
                spacesToDistribute--;
            }
        }

        while (sb.length() < maxWidth) {
            sb.append(" ");
        }

        return sb.toString();
    }
}