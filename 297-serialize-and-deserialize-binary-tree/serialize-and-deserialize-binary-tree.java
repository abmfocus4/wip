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
    String delimit = ",";
    String nullStr = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return nullStr;
        return root.val + delimit + serialize(root.left) + delimit + serialize(root.right);
    }

    Queue<String> q;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.q = new LinkedList(Arrays.asList(data.split(delimit)));
        return dfs();
    }

    public TreeNode dfs() {
        String val = q.poll();
        if (val.equals(nullStr)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs();
        root.right = dfs();
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));