class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // level order traversal, let the last element in the level
        List<Integer> result = new ArrayList();
        Queue<TreeNode> q = new LinkedList();
        if (root != null) q.add(root);
        while (q.isEmpty() == false) {
            int levelLength = q.size();
            int val = 0;
            for (int i = 0; i < levelLength; i++) {
                TreeNode cur = q.poll();
                val = cur.val;
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            result.add(val);
        }

        return result;
    }
}