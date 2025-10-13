class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> sentences; // store sentence and hot count
    
    public TrieNode() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}

class AutocompleteSystem {
    TrieNode root;
    TrieNode currNode;
    StringBuilder currSentence;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for (int i = 0; i < sentences.length; i++) {
            addToTrie(sentences[i], times[i]);
        }
        
        currSentence = new StringBuilder();
        currNode = root;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            addToTrie(currSentence.toString(), 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<>();
        }
        
        currSentence.append(c);
        
        // If already in invalid state or character not found
        if (currNode == null || !currNode.children.containsKey(c)) {
            currNode = null;
            return new ArrayList<>();
        }
        
        currNode = currNode.children.get(c);
        return getTop3(currNode.sentences);
    }
    
    private List<String> getTop3(Map<String, Integer> sentences) {
        // remove lowest freq
        // if tied, remove last word in dict
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int hotA = sentences.get(a);
            int hotB = sentences.get(b);
            if (hotA == hotB) {
                return b.compareTo(a);  // Reverse lex order of string
            }
            return hotA - hotB;  // Ascending frequency (min-heap)
        });
        
        for (String sentence : sentences.keySet()) {
            heap.add(sentence);
            if (heap.size() > 3) {
                heap.remove();  // Remove worst (lowest priority)
            }
        }
        
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.remove());
        }
        
        Collections.reverse(ans);  // Convert to descending order
        return ans;
    }
    
    private void addToTrie(String sentence, int count) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            
            node = node.children.get(c);
            // at each node, store sentence and its hot count
            node.sentences.put(sentence, 
                node.sentences.getOrDefault(sentence, 0) + count);
        }
    }
}