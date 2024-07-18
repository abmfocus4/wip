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
            Queue<TreeNode> q = new LinkedList();
            HashSet<TreeNode> seen = new HashSet();
            q.add(leaf);
            seen.add(leaf);

            for (int i = 0; i <= distance; i++) {
                int size = q.size();
                while (size-- > 0) { // at each level
                    TreeNode curNode = q.poll();
                    // process level
                    if (curNode != leaf && leafNodes.contains(curNode)) {
                        ans++;
                    }

                    // add neighbours
                    if (graph.get(curNode) == null) continue;
                    for (TreeNode nei : graph.get(curNode)) {
                        if (seen.contains(nei) == false) {
                            q.add(nei);
                            seen.add(nei);
                        }

                    }
                }
            }
        }


        return ans/2;
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