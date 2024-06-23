class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] acgt = {'A', 'C', 'G', 'T'};
        // construct bank
        HashSet<String> bankSet = new HashSet();
        for(String str : bank) {
            bankSet.add(str);
        }
        // use q for bfs
        Queue<String> q = new LinkedList();
        // set for visited tracking
        HashSet<String> visited = new HashSet();
        
        // add start
        q.add(startGene);
        visited.add(startGene);

        int level = 0;

        while(q.isEmpty() == false) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                String curGene = q.poll();
                if (curGene.equals(endGene)) {
                    return level;
                }

                char[] curGeneArr = curGene.toCharArray();
                for (int i = 0; i < curGeneArr.length; i++) {
                    char origChar = curGeneArr[i];
                    for (char c : acgt) {
                        curGeneArr[i] = c;
                        String newGene = new String(curGeneArr);
                        if (visited.contains(newGene)) {
                            continue;
                        }

                        if (bankSet.contains(newGene)) {
                            q.add(newGene);
                            visited.add(newGene);
                        }
                    }
                    curGeneArr[i] = origChar;
                }

            }
            level++;
        }

        return -1;
    }
}