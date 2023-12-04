/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 // https://www.youtube.com/watch?v=NoHwJP7xPxg
 // Recusion DFS PreOrder Tranversal
public class Codec {
    final String nullNode = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return nullNode;
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    String arr[];
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        return dfs();
    }

    private TreeNode dfs() {
        // base case
        if (arr[index].equals(nullNode)) {
            index++;
            return null;
        }
        // deserialize the current value
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        // build our left subtree and return its root
        root.left = dfs();
        // build our right subtree and return its root
        root.right = dfs();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));