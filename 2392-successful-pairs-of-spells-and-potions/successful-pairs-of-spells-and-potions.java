class Solution {
    // https://leetcode.com/problems/successful-pairs-of-spells-and-potions/solutions/3367914/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        Arrays.sort(potions);
        
        for (int i = 0; i < n; i++) {
            int spell = spells[i];

            int left = 0;
            int right = m - 1;
            
            // getting smallest portion success
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long product = (long) spell * potions[mid];
                if (product >= success) { // greater than or equal
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            pairs[i] = m - left; // left is the smallest success, everyting from left onwards in success
        }
        
        return pairs;
    }
}