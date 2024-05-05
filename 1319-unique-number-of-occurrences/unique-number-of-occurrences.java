// https://leetcode.com/problems/unique-number-of-occurrences/solutions/4577893/beats-100-users-c-java-python-javascript-2-approaches-explained
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // Set<Integer> s = new HashSet<>();
        // for (int x : freq.values()) {
        //     s.add(x);
        // }

        Set<Integer> s = new HashSet<>(freq.values());
        // freq.size() == # of distinct elems
        // s.size() == # of distinct frequencies
        return freq.size() == s.size();
    }
}
