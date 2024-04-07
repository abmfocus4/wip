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
        // bfs traveral - use q to store old nodes
        // visited map to store old node -> new node/clone

        if (node == null) return null;
        Queue<Node> q = new LinkedList();
        HashMap<Node, Node> map = new HashMap();
        q.add(node);
        map.put(node, new Node(node.val));

        while (q.isEmpty() == false) {
            Node curNode = q.remove();
            Node curClone = map.get(curNode); // err
            for (Node neighbor : curNode.neighbors) {
                Node cloneNeighbor;
                if (map.containsKey(neighbor)) {
                    cloneNeighbor = map.get(neighbor);
                } else {
                    cloneNeighbor = new Node(neighbor.val);
                    q.add(neighbor);
                    map.put(neighbor, cloneNeighbor);
                }
                curClone.neighbors.add(cloneNeighbor);
            }
        }
        return map.get(node);
    }
}