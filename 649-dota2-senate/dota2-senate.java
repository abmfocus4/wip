class Solution {
    public String predictPartyVictory(String senate) {
        int num_r = 0, num_d = 0;

        int n = senate.length();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') num_r++;
            else num_d++;
        }

        Set<Integer> bannedIdx = new HashSet();

        while (num_r != 0 && num_d != 0) {
            for (int i = 0; i < n; i++) {
                if (num_r == 0 || num_d == 0) break;
                if (bannedIdx.contains(i)) continue;
                int j = (i + 1)%n;
                while (j != i) {
                    if (bannedIdx.contains(j) == false && senate.charAt(i) != senate.charAt(j)) {
                        bannedIdx.add(j);
                        if (senate.charAt(j) == 'R') num_r--;
                        else num_d--;
                        break;
                    }
                    j = (j+1)%n;
                }
            }
        }

        if (num_r == 0) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}