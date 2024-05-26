// https://www.youtube.com/watch?v=H3kSFSv-t30&ab_channel=codestorywithMIK
// optimization: instead of using another visited arr, by bank is too large, you can consider removing the gene directly from bank
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] AGCT = { 'A', 'G', 'C', 'T' };

        HashSet<String> bankSet = new HashSet();
        for (String str : bank) {
            bankSet.add(str);
        }

        Queue<String> q = new LinkedList();
        HashSet<String> visited = new HashSet();
        q.add(startGene);
        visited.add(startGene);
        int level = 0;

        while (q.isEmpty() == false) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                String curGene = q.poll();
                if (curGene.equals(endGene)) {
                    return level;
                }

                char[] curGeneArr = curGene.toCharArray();
                for (int i = 0; i < curGeneArr.length; i++) {
                    char origChar = curGeneArr[i];
                    for (char c : AGCT) {
                        curGeneArr[i] = c;
                        String updatedGene = new String(curGeneArr);
                        if (visited.contains(updatedGene)) {
                            continue;
                        }
                        if (bankSet.contains(updatedGene)) {
                            visited.add(updatedGene);
                            q.add(updatedGene);
                        }

                    }
                    curGeneArr[i] = origChar; // set to original after experiments
                }
            }
            level++;
        }

        return -1;
    }
}