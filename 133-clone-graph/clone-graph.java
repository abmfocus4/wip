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
        // do bfs traversal
        // queue to keep track of traversed nodes in order of orig nodes
        // visited map with orig node and clone node

        if (node == null) return null;

        Queue<Node> q = new LinkedList();
        q.add(node);

        HashMap<Node, Node> visited = new HashMap();
        visited.put(node, new Node(node.val));

        while (q.isEmpty() == false)
        {
            Node curNode = q.poll();
            Node curNodeClone = visited.get(curNode);
            for (Node neighbor : curNode.neighbors) {
                if (!visited.containsKey(neighbor))
                {
                    // create neighbor clone
                    Node neighborNodeClone = new Node(neighbor.val);
                    // add to q
                    q.add(neighbor);
                    // add node and clone to map
                    visited.put(neighbor, neighborNodeClone);
                }
                curNodeClone.neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}