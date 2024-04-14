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
        // visited map (node.val and node clone)
        return cloneGraphWithVisited(node, new HashMap<Integer, Node>());
    }

    public Node cloneGraphWithVisited(Node node, HashMap<Integer, Node> visited) {
        if (node == null) return null;

        if (visited.containsKey(node.val)) return visited.get(node.val);

        Node nodeClone = new Node(node.val);
        visited.put(node.val, nodeClone);
        for (Node neighbor : node.neighbors) {
            nodeClone.neighbors.add(cloneGraphWithVisited(neighbor, visited));
        }

        return nodeClone;
    }
}