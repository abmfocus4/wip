// similar to gene mutation problem
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordListSet = new HashSet();
        for (String str : wordList) {
            wordListSet.add(str);
        }

        Queue<String> q = new LinkedList();
        q.add(beginWord); // no need to check if in the wordlistSet or not
        
        HashSet<String> visited = new HashSet();
        visited.add(beginWord);

        int level = 1; // begin word is part of mutation

        while (q.isEmpty() == false) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                String curWord = q.poll();
                if (curWord.equals(endWord)) {
                    return level;
                }
                char[] curWordArr = curWord.toCharArray();
                for (int i = 0; i < curWordArr.length; i++) {
                    char origChar = curWordArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        curWordArr[i] = c;
                        String updatedWord = new String(curWordArr);
                        if (visited.contains(updatedWord)) {
                            continue;
                        }
                        if (wordListSet.contains(updatedWord)) {
                            q.add(updatedWord);
                            visited.add(updatedWord);
                        }
                    }
                    curWordArr[i] = origChar;
                }
            }
            level++;
        }

        return 0; // return 0 instead of -1
    }
}