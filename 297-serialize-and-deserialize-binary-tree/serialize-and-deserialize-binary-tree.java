/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Ref: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solutions/281714/clean-java-solution/
// Interative serialization
public class Codec {
    final String nullNode = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return nullNode;
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList(Arrays.asList(data.split(",")));
        return dfs(q);
    }

    private TreeNode dfs(Queue<String> q) {
        String value = q.poll();
        if (value.equals(nullNode)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = dfs(q);
        root.right = dfs(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));