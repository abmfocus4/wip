class Trie {
    Map<String, Trie> children;
    String name;
    StringBuilder content;

    Trie(String name) {
        this.children = new HashMap();
        this.name = name;
        this.content = new StringBuilder();
    }
    boolean isFile() {
        return content.isEmpty() == false;
    }

    void addContent(String extraContent) {
        content.append(extraContent);
    }
}
class FileSystem {
    Trie root;
    public FileSystem() {
        this.root = new Trie("/");
    }

    private Trie findNode(String path) {
        Trie cur = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.isEmpty()) {
                continue;
            }
            if (cur.children.containsKey(dir) == false) {
                cur.children.put(dir, new Trie(dir));
            }
            cur = cur.children.get(dir);
            if (cur.isFile()) {
                break;
            }
        }
        return cur;
    }
    
    public List<String> ls(String path) {
        Trie cur = findNode(path);
        List<String> list = new ArrayList();
        if (cur.isFile()) {
            list.add(cur.name);
            return list;
        } else {
            list.addAll(cur.children.keySet());
            Collections.sort(list);
            return list;
        }
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        Trie node = findNode(filePath);
        node.addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        Trie node = findNode(filePath);
        return node.content.toString();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */