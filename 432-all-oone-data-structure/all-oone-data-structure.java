class AllOne {
    private Node head;
    private Node tail;
    Map<String, Node> map;

    public AllOne() {
        this.head = new Node("", -1);
        this.tail = new Node("", -1);
        head.next = tail;
        tail.pre  = head;
        this.map = new HashMap<>();
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.freq++;
            moveUp(node);
        }else{
            Node node = new Node(key, 1);
            map.put(key, node);
            addLast(node);
        }
    }
    
    public void dec(String key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(node.freq==1){
                map.remove(key);
                remove(node);    
            }else{
                node.freq = node.freq-1;
                moveDown(node);
            }
        }
    }
    
    public String getMaxKey() {
        return head.next.key;
    }
    
    public String getMinKey() {
        return tail.pre.key;
    }

    private void remove(Node node){
        Node pre = node.pre;
        Node next = node.next;
        next.pre = pre;
        pre.next = next;
        node.next = null;
        node.pre = null;
    }

    private void moveUp(Node node){
        while(node.pre.pre !=null && node.freq > node.pre.freq){
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;

            node.next = pre;
            pre.pre.next = node;
            node.pre = pre.pre;
            pre.pre = node;
        }
    }

    private void moveDown(Node node){
        while(node.next.next !=null && node.freq< node.next.freq){
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;

            node.pre = next;
            next.next.pre = node;
            node.next = next.next;
            next.next = node;
        }
    }

    private void addLast(Node node){
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }
}

class Node{
    int freq;
    Node pre;
    Node next;
    String key;


    public Node(String key, int freq){
        this.key = key;
        this.freq = freq;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */