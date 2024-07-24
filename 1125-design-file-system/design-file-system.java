class TrieNode {
	String name;
	int value;
	Map<String, TrieNode> children;

	TrieNode(String name, int value) {
		this.name = name;
		this.value = value;
		this.children = new HashMap<>();
	}
}

class FileSystem {
	private TrieNode root;

    public FileSystem() {
        this.root = new TrieNode("/", -1);
    }
    
    public boolean createPath(String path, int value) {
        String[] dirs = path.split("/");

        TrieNode currNode = this.root;
        String name = dirs[dirs.length - 1];

        // stop at the second last dir
        for (int i = 0; i < dirs.length - 1; i++) {
            if (dirs[i].equals("")) {
                continue;
            }
        	if (currNode.children.containsKey(dirs[i])) {
        		currNode = currNode.children.get(dirs[i]);
        	} else {
        		return false;
        	}
        }
        
        // trying to create new directory
        // check if the path exists
        if (currNode.children.containsKey(name)) {
            return false;
        }

        currNode.children.put(name, new TrieNode(name, value));
        return true;
    }
    
    public int get(String path) {
        String[] dirs = path.split("/");
        TrieNode currNode = this.root;

        for (String dir: dirs) {
            if (dir.equals("")) {
                continue;
            }
        	if (currNode.children.containsKey(dir)) {
        		currNode = currNode.children.get(dir);
        	} else {
        		return -1;
        	}
        }

        return currNode.value;
    }
}