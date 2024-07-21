/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, List<TreeNode>> graph;
    HashSet<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.graph = new HashMap();
        buildGraph(root, null);
        this.visited = new HashSet();
        visited.add(target);
        List<Integer> res = new ArrayList();
        dfs(target, k, 0, res);
        return res;
    }

    private void dfs(TreeNode node, int k, int distance, List<Integer> res) {
        if (distance == k) {
            res.add(node.val);
            return;
        }

        if (graph.get(node) == null || graph.get(node).isEmpty()) {
            return;
        }
        
        for (TreeNode neigh : graph.get(node)) {
            if (!visited.contains(neigh)) {
                visited.add(neigh);
                dfs(neigh, k, distance + 1, res);
            }
        }
    }

    private void buildGraph(TreeNode cur, TreeNode parent) {
        if (cur != null && parent != null) {
            graph.computeIfAbsent(cur, x -> new ArrayList()).add(parent);
            graph.computeIfAbsent(parent, x -> new ArrayList()).add(cur);
        }

        if (cur.left != null) {
            buildGraph(cur.left, cur);
        }

        if (cur.right != null) {
            buildGraph(cur.right, cur);
        }
    }
}