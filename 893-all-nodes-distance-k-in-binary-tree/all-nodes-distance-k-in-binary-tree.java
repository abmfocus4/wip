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
    Map<TreeNode, List<TreeNode>> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // construct graph
        // dfs or bfs
        if (k == 0) return List.of(target.val);
        this.graph = new HashMap();
        buildGraph(root, null);
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        HashSet<TreeNode> visited = new HashSet();
        visited.add(target);
        List<Integer> list = new ArrayList();
        bfs(q, visited, k, list);
        return list;
    }

    private void bfs(Queue<TreeNode> q, HashSet<TreeNode> visited, int k, List<Integer> res) {
        while (q.isEmpty() == false) {
            int levelSize = q.size();
            k--;
            while (levelSize-- > 0) {
                TreeNode cur = q.poll();
                if (graph.get(cur) == null || graph.get(cur).size() == 0) continue;
                for (TreeNode neigh : graph.get(cur)) {
                    if (visited.contains(neigh)) continue;
                    if (k == 0) res.add(neigh.val);
                    q.add(neigh);
                    visited.add(neigh);
                }
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