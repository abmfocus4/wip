/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    final String nullNode = "#";
    final String delimeter = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return nullNode;
        return root.val +  delimeter + serialize(root.left) + delimeter + serialize(root.right);
    }

    String arr[];
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        arr = data.split(delimeter);
        return dfs();
    }

    // string -> node
    public TreeNode dfs() {
        if (arr[index].equals(nullNode)) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        root.left = dfs();
        root.right = dfs();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));