public class FileSystem {
    private class TrieNode {
        private HashMap<String, TrieNode> children;
        private StringBuilder content;
        private String name;

        public TrieNode(String name) {
            children = new HashMap<>();
            content = new StringBuilder();
            this.name = name;
        }

        public String getContent() {
            return content.toString();
        }

        public String getName() {
            return name;
        }

        public void addContent(String content) {
            this.content.append(content);
        }

        public boolean isFile() {
            return this.content.length() > 0;
        }
    }

    private TrieNode root;

    public FileSystem() {
        root = new TrieNode("");
    }

    public List<String> ls(String path) {
        TrieNode cur = findNode(path);
        List<String> list = new ArrayList<>();
        if (cur.isFile()) {
            list.add(cur.getName());
        } else {
            list.addAll(cur.children.keySet());
        }

        Collections.sort(list); // return in lexi
        return list;
    }

    public void mkdir(String path) {
        findNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }

    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }

    private TrieNode findNode(String path) {
        TrieNode cur = root;
        
        String[] files = path.split("/");
        for (String file : files) {
            if (file.length() == 0)
                continue;

            if (cur.children.get(file) == null) {
                cur.children.put(file, new TrieNode(file));
            }
            cur = cur.children.get(file);

            if (cur.isFile())
                break;
        }

        return cur;
    }
}