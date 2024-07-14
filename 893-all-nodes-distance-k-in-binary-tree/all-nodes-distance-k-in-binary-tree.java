/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//  https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solutions/143798/1ms-beat-100-simple-java-dfs-with-without-hashmap-including-explanation
class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        search(root, 0, K, res);
        return res;
    }

	// store the distance between the ancestor of target node and the target node
    private void find(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }

        if (root == target) {
            map.put(root, 0);
            return;
        }

        find(root.left, target);
        if (map.containsKey(root.left)) {
            map.put(root, map.get(root.left) + 1);
            return;
        }

        find(root.right, target);
        if (map.containsKey(root.right)) {
            map.put(root, map.get(root.right) + 1);
            return;
        }
        return;
    }

    public void search(TreeNode root, int dis, int K, List<Integer> res) {
        if (root == null) {
            return;
        }

        //if node is the ancestor of target node, 
		//we use the stored value in hashmap instead of the value (parameter len) from its parent node.
        if (map.containsKey(root)) {
            dis = map.get(root);
        }

        if (dis == K) {
            res.add(root.val);
        }
        
        //if the distance from a node to target node is k, 
		//the distance from its child to the target node is k + 1,
		//unless the child node is closer to the target node which means the target node is in it's subtree.
        search(root.left, dis + 1, K, res);
        search(root.right, dis + 1, K, res);
    }
}