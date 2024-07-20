class Solution {
    // https://www.youtube.com/watch?v=3OXWEdlIGl4&list=TLPQMDEwNjIwMjSUjnvbX72tSg&index=7&ab_channel=takeUforward
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);

        boolean flag = true; // true is L to R and false is R to L

        while(!dq.isEmpty()) {
            int levelSize = dq.size();
            List<Integer> levelList = new ArrayList<>();
            while (levelSize-- > 0) {
                TreeNode cur = flag ? dq.pollFirst() : dq.pollLast();
                levelList.add(cur.val);
                if (flag) {
                    if (cur.left != null) dq.addLast(cur.left);
                    if (cur.right != null) dq.addLast(cur.right);
                } else {
                    if (cur.right != null) dq.addFirst(cur.right);
                    if (cur.left != null) dq.addFirst(cur.left);
                }
            }
            result.add(levelList);
            flag = !flag; // change dir for next level
        }
        return result;
    }
}