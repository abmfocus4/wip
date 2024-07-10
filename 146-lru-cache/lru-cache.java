class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node() {}
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, Node> map;
    int capacity;
    Node head = new Node(), tail = new Node();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        }

        Node valNode = map.get(key);
        remove(valNode);
        insert(valNode);
        return valNode.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.remove(key));
        }
        if (capacity == map.size()) remove(tail.prev);
        Node valNode = new Node(key, value);
        insert(valNode);
    }

    private void insert(Node node) {
        map.put(node.key, node);
        // head should point to new node
        Node oldHead = head.next;
        head.next = node;
        node.next = oldHead;
        node.prev = head;
        oldHead.prev = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */