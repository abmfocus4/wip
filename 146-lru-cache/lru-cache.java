class LRUCache {
    class Node {
        int key, val;
        Node next, prev;
        Node() {};
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;
    public LRUCache(int capacity) {
        this.map = new HashMap();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key) == false) {
            return -1;
        }

        Node nodeVal = map.get(key);
        remove(nodeVal);
        insert(nodeVal);
        return nodeVal.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        if (capacity == map.size()) {
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node oldHead = head.next;
        head.next = node;
        node.next = oldHead;
        node.prev = head;
        oldHead.prev = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */