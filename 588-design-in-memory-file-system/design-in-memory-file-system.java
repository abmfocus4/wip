class FileSystem {
    private class TrieNode {
        private HashMap<String, TrieNode> children;
        private StringBuilder content;
        private String name;

        public TrieNode(String name) {
            this.name = name;
            this.content = new StringBuilder();
            this.children = new HashMap();
        }

        public boolean isFile() {
            return content.length() > 0;
        }

    }

    private TrieNode root;

    public FileSystem() {
        this.root = new TrieNode("");
    }

    private TrieNode findNode(String path) {
        TrieNode cur = root;
        String[] files = path.split("/");
        for (String file : files) {
            if (file.length() == 0) {
                continue;
            }

            if (cur.children.get(file) == null) {
                cur.children.put(file, new TrieNode(file));
            }
            cur = cur.children.get(file);

            if (cur.isFile()) {
                break;
            }
        }
        return cur;
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList();
        TrieNode cur = findNode(path);
        if (cur.isFile()) {
            result.add(cur.name);
        } else {
            result.addAll(cur.children.keySet());
        }
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        findNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        findNode(filePath).content.append(content);
    }

    public String readContentFromFile(String filePath) {
        return findNode(filePath).content.toString();
    }

    public boolean rmdir(String path) {
        if (path.equals("/") || path.isEmpty()) {
            return false; // cannot remove root
        }

        String[] files = path.split("/");
        TrieNode cur = root;
        for (int i = 1; i < files.length - 1; i++) { // traverse till parent
            if (!cur.children.containsKey(files[i])) {
                return false; // parent doesn't exist
            }
            cur = cur.children.get(files[i]);
        }

        String target = files[files.length - 1];
        TrieNode toRemove = cur.children.get(target);
        if (toRemove == null)
            return false; // not found

        // fail if not a directory or not empty
        if (toRemove.isFile() || !toRemove.children.isEmpty()) {
            return false;
        }

        cur.children.remove(target);
        return true;
    }

    public boolean rename(String path, String newName) {
        String[] files = path.split("/");
        TrieNode cur = root;

        // Traverse until parent of target
        for (int i = 0; i < files.length - 1; i++) {
            if (files[i].length() == 0) {
                continue;
            }

            if (!cur.children.containsKey(files[i])) {
                return false; // parent path doesn’t exist
            }

            cur = cur.children.get(files[i]);
        }

        String oldName = files[files.length - 1];
        TrieNode nodeToRename = cur.children.get(oldName);
        if (nodeToRename == null) {
            return false; // no such file/dir
        }

        // Check collision: if "newName" already exists in same directory
        if (cur.children.containsKey(newName)) {
            return false; // target already exists
        }

        // Remove old entry and reinsert with new name
        cur.children.remove(oldName);
        nodeToRename.name = newName; // update node's internal name
        cur.children.put(newName, nodeToRename);

        return true;
    }

    public boolean mv(String srcPath, String dstPath) {
        if (srcPath.equals("/") || dstPath.equals("/") ||
                srcPath.isEmpty() || dstPath.isEmpty()) {
            return false; // can't move root
        }

        String[] srcFiles = srcPath.split("/");
        String[] dstFiles = dstPath.split("/");

        // --- Step 1: Find source parent ---
        TrieNode srcParent = root;
        for (int i = 1; i < srcFiles.length - 1; i++) {
            if (!srcParent.children.containsKey(srcFiles[i]))
                return false;
            srcParent = srcParent.children.get(srcFiles[i]);
        }

        String srcName = srcFiles[srcFiles.length - 1];
        TrieNode srcNode = srcParent.children.get(srcName);
        if (srcNode == null)
            return false;

        // --- Step 2: Find destination parent ---
        TrieNode dstParent = root;
        for (int i = 1; i < dstFiles.length; i++) {
            if (!dstParent.children.containsKey(dstFiles[i])) {
                return false; // destination parent doesn't exist
            }
            dstParent = dstParent.children.get(dstFiles[i]);
        }

        // --- Step 3: Relocate ---
        if (dstParent.children.containsKey(srcName)) {
            return false; // collision
        }
        srcParent.children.remove(srcName);
        dstParent.children.put(srcName, srcNode);

        return true;
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