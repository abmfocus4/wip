// https://www.youtube.com/watch?v=jpU2LVaDa4g&ab_channel=codestorywithMIK
class Solution {
    int MAX_WIDTH;
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int n     = words.length;
        this.MAX_WIDTH = maxWidth;
        int i     = 0, j = 0;

        int spaceBetweenWords = 0, extraSpacesToDistribute = 0;
        int lettersCount = 0, spaceSlots = 0;
        int remainingSlots = 0;
        
        while(i < n) {
            lettersCount = words[i].length();
            j            = i+1;
            spaceSlots   = 0;
            
            while(j < n && (spaceSlots + lettersCount + words[j].length() + 1 <= maxWidth)) { // keep adding words to line
                lettersCount += words[j].length();
                spaceSlots   += 1;
                j++;
            }
            
            remainingSlots = maxWidth - lettersCount; // remaining slots in line
            
            if (j == n) { // if the line we just processed is the last line
                spaceBetweenWords = 1;
                extraSpacesToDistribute    = 0;
            } else {
                spaceBetweenWords = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots; // evenly divide remaining spaces
                extraSpacesToDistribute = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots; // extra spaces after even division
            }
            
            lines.add(getLine(i, j, spaceBetweenWords, extraSpacesToDistribute, words));
            i = j; // process next line
        }
        
        return lines;
    }
    
    private String getLine(int i, int j, int spaceBetweenWords, int extraSpacesToDistribute, String[] words) {
        StringBuilder s = new StringBuilder();

        for(int k = i; k < j; k++) {
            s.append(words[k]);

            if(k == j-1) // if it is last line, don't add spaces or do anything fancy
                break;

            for(int space = 1; space <= spaceBetweenWords; space++)
                s.append(" ");

            if(extraSpacesToDistribute > 0) { // distribute extra spaces from left to right 1 each
                s.append(" ");
                extraSpacesToDistribute--;
            }
        }

        while(s.length() < MAX_WIDTH) { // pad with extra spaces
            s.append(" ");
        }
        
        return s.toString();
    }
    
}