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

class Solution {
    public Node cloneGraph(Node node) {
        // issue is that we keep recursing indefinitely
        // need to keep reference to created nodes (map with node and clone created - reuse)
        return cloneGraphWithMap(node, new HashMap<Node, Node>());
    }

    public Node cloneGraphWithMap(Node node, HashMap<Node, Node> visited) {
        if (node == null) return null;

        if (visited.containsKey(node)) return visited.get(node); 

        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphWithMap(neighbor, visited));
        }

        return clone;
    }
}