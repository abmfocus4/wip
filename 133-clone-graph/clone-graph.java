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
// BFS: queue
// DFS: stack
class Solution {
public Node cloneGraph(Node node) {
        return cloneGraphWithVisited(node, new HashMap<Integer, Node>());
    }
    
    // visited map used to keep track of nodes that are already visited so we don't recurse indefinitely
    public Node cloneGraphWithVisited(Node node, Map<Integer, Node> visited) {
        // base case
        if (node == null) return null;
        
        // if node was already visited
        if (visited.containsKey(node.val)) return visited.get(node.val); 
        
        // if unvisited node, create clone
        Node clone = new Node(node.val, new ArrayList<Node>()); // create node
        visited.put(node.val, clone); // add to list
        for(Node neighbor: node.neighbors) { // recurse on neighbours
            clone.neighbors.add(cloneGraphWithVisited(neighbor, visited));
        }
        
        return clone; // return clone
    }
}