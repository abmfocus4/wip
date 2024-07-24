class FileSystem {
    class Trie {
        Map<String, Trie> children;
        String name;
        int value;

        public Trie(String name) {
            this.children = new HashMap<>();
            this.name = name;
            this.value = -1;
        }
    }

    Trie root;
    public FileSystem() {
        this.root = new Trie("/");
    }
    
    public boolean createPath(String path, int value) {
        Trie cur = root;
        String[] dirs = path.split("/");

        for (int i = 0; i < dirs.length - 1; i++) {
            String dir = dirs[i];
            if (dir.isEmpty()) continue;
            if (cur.children.containsKey(dir) == false) {
                return false;
            }
            cur = cur.children.get(dir);
        }

        String newDir = dirs[dirs.length - 1];
        if (cur.children.containsKey(newDir)) {
            return false;
        }

        cur.children.put(newDir, new Trie(newDir));
        cur = cur.children.get(newDir);
        cur.value = value;
        return true;
    }
    
    public int get(String path) {
        Trie cur = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty()) continue;
            if (cur.children.containsKey(dir) == false) {
                return -1;
            }
            cur = cur.children.get(dir);
        }

        return cur.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */