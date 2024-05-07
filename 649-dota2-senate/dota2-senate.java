// https://www.youtube.com/watch?v=zZA5KskfMuQ&ab_channel=NeetCodeIO
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r_q = new LinkedList();
        Queue<Integer> d_q = new LinkedList();
        int senate_len = senate.length();

        char[] senate_arr = senate.toCharArray();

        for (int i = 0; i < senate_arr.length; i++) {
            if (senate_arr[i] == 'R') {
                r_q.add(i);
            } else {
                d_q.add(i);
            }
        }

        while (r_q.isEmpty() == false && d_q.isEmpty() == false) {
            int r = r_q.poll(); // greedy: kick out nearest neighbour
            int d = d_q.poll();
            if (r < d) { // r comes before d
                r_q.add(r + senate_len); // kick d out and push r into circulation at the end
            } else {
                d_q.add(d + senate_len);
            }
        }

        if (r_q.size() > d_q.size()) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}