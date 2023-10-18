// Ref: look at editorial tab
// brute force: bfs graph search
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet(wordDict); // constant lookup of 
        Queue<Integer> q = new LinkedList(); // keep track of work startings
        q.add(0); // init q
        boolean[] seen = new boolean[s.length() + 1]; // visit node only once

        while (q.isEmpty() == false) { // iterate until queue is empty
            int start = q.remove(); // get first q element
            if (start == s.length()) return true; // if we reached end of word
            for (int end = start + 1; end <= s.length(); end++) { // for each start iterate through end of word to make sure all 
                if (seen[end]) continue; // if already visited

                if (set.contains(s.substring(start, end))) { // check if string in dict
                    q.add(end); // add to start list
                    seen[end] = true; // update to make sure same node is not visited again
                }
            }
        }
        return false;
    }
}