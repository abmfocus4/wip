/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // difference between this problem and serde of plain bt is that the str needs to be as compact as possible
 // because it's a bst we can save space used for saving null nodes (#)

 // Ref: https://leetcode.com/problems/serialize-and-deserialize-bst/solutions/177617/the-general-solution-for-serialize-and-deserialize-bst-and-serialize-and-deserialize-bt/?envType=list&envId=pxw54vnt

//  if (val < lower || val > upper) return null;
// is used to determine when to change direction.

// https://leetcode.com/problems/serialize-and-deserialize-bst/solutions/177617/the-general-solution-for-serialize-and-deserialize-bst-and-serialize-and-deserialize-bt/comments/214024

 // check comments for how lower and upper bounds are changed
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(Queue<String> q, int low, int high) {
        if (q.isEmpty()) return null;
        int value = Integer.parseInt(q.peek());
        if (value < low || value > high) return null;
        TreeNode root = new TreeNode(value);
        q.poll();
        root.left = dfs(q, low, value);
        root.right = dfs(q, value, high);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;