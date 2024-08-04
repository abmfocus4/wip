/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, List<TreeNode>> graph;
    int count;
    public int countPairs(TreeNode root, int distance) {
        // get all the leaf nodes
        // prepare graph
        // bfs from each leaf node till distance levels
        // count all leaf nodes encountered during this process except current leaf
        // divide total ans by 2 to account for double counting
        this.graph = new HashMap();
        List<TreeNode> leafNodes = new ArrayList();
        buildGraph(root, null, leafNodes);
        this.count = 0;
        for (TreeNode leafNode : leafNodes) {
            Queue<TreeNode> q = new LinkedList();
            HashSet<TreeNode> visited = new HashSet();
            q.add(leafNode);
            visited.add(leafNode);
            bfs(q, visited, distance, leafNode, leafNodes);
        }
        System.out.println(count);
        return count/2;
    }

    void bfs(Queue<TreeNode> q, HashSet<TreeNode> visited, int distance, TreeNode startNode, List<TreeNode> leafNodes) {
        for (int i = 0; i < distance; i++) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                TreeNode cur = q.poll();
                if (graph.get(cur) == null || graph.get(cur).size() == 0) continue;
                for (TreeNode neigh : graph.get(cur)) {
                    if (visited.contains(neigh)) continue;
                    if (neigh != startNode && leafNodes.contains(neigh)) count++;
                    q.add(neigh);
                    visited.add(neigh);
                }
            }
        }
    }


    void buildGraph(TreeNode cur, TreeNode parent, List<TreeNode> leafNodes) {
        if (cur != null && parent != null) {
            graph.computeIfAbsent(cur, x -> new ArrayList()).add(parent);
            graph.computeIfAbsent(parent, x -> new ArrayList()).add(cur);
        }

        if (cur.left == null && cur.right == null) {
            leafNodes.add(cur);
        }

        if (cur.left != null) {
            buildGraph(cur.left, cur, leafNodes);
        }

        
        if (cur.right != null) {
            buildGraph(cur.right, cur, leafNodes);
        }
    }
}