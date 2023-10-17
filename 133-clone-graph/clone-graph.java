/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
// Ref: https://www.youtube.com/watch?v=t9pj1Ail2z4&t=354s
class Solution {
    public Node cloneGraph(Node node) {
        // edge case
        if (node == null) return null;
        // perform graph search BFS (use queue) of [actual nodes]
        Queue<Node> q = new LinkedList();
        // keep track of visited [actual nodes] and their [clones] using hash table
        HashMap<Node, Node> hm = new HashMap();

        // init q and hm
        q.add(node);
        hm.put(node, new Node(node.val));

        while (q.isEmpty() == false) {
            Node first = q.remove(); // get the top
            Node firstClone = hm.get(first); // get the clone

            for (Node neighbor : first.neighbors) {
                Node neighborClone; // neighbor clone
                if (hm.containsKey(neighbor)) { // already visited neighbor node
                    neighborClone = hm.get(neighbor); // simply get already visited clone
                } else { // never visited neighbor node
                    neighborClone = new Node(neighbor.val); // create new node
                    hm.put(neighbor, neighborClone); // add to hash map
                    q.add(neighbor); // add to queue
                }
                firstClone.neighbors.add(neighborClone); // add neighbor clone to neigbor parent node
            }
        }
        return hm.get(node);
    }
}