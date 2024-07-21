/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap();
        Set<TreeNode> leafNodes = new HashSet();
        traverseTree(root, null, graph, leafNodes);

        int ans = 0;

        // for each leaf node,
        // run bfs for distance
        // count number of leaf nodes encountered
        for (TreeNode leaf : leafNodes) {
            ans += bfs(leaf, leafNodes, graph, distance);
        }

        return ans/2;
    }

    private int bfs(TreeNode node, Set<TreeNode> leafNodes, Map<TreeNode, List<TreeNode>> graph, int dist) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList();
        HashSet<TreeNode> visited = new HashSet();
        q.add(node);
        visited.add(node);

        for (int i = 0; i <= dist; i++) {
            int levelSize = q.size();
            while (levelSize-- > 0) {
                TreeNode cur = q.poll();
                if (leafNodes.contains(cur) && node != cur) {
                    count++;
                }

                if (graph.get(cur) == null || graph.get(cur).isEmpty()) continue;
                for (TreeNode neigh : graph.get(cur)) {
                    if (!visited.contains(neigh)) {
                        visited.add(neigh);
                        q.add(neigh);
                    }
                }
            }
        }
        return count;        
    }

    private void traverseTree(TreeNode curNode, TreeNode prevNode, Map<TreeNode, List<TreeNode>> graph, Set<TreeNode> leafNodes) {
        if (curNode == null) {
            return;
        }

        if (curNode.left == null && curNode.right == null) {
            leafNodes.add(curNode);
        }

        if (prevNode != null) {
            if (graph.containsKey(curNode) == false) {
                graph.put(curNode, new ArrayList());
            }
            graph.get(curNode).add(prevNode);

            if (graph.containsKey(prevNode) == false) {
                graph.put(prevNode, new ArrayList());
            }

            graph.get(prevNode).add(curNode);
        }

        traverseTree(curNode.left, curNode, graph, leafNodes);
        traverseTree(curNode.right, curNode, graph, leafNodes);
    }
}