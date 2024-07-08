class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> vv = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        TreeNode p, t = root;
        int m = 0;
        while (t != null) {
            m += t.val;
            v.add(t.val);
            if ((p = t.left) != null) {
                int d = 1, n = p.val;
                v.add(p.val);
                while (p.right != null && p.right != t) {
                    p = p.right;
                    v.add(p.val);
                    n += p.val;
                    d++;
                }
                if (p.right != null) {
                    p.right = null;
                    m -= t.val + n;
                    for (int i = 0; i < 2 * d + 1; i++) v.remove(v.size() - 1);
                    t = t.right;
                } else {
                    p.right = t;
                    if (p.left == null && m + n == sum) vv.add(new ArrayList<>(v));
                    for (int i = 0; i < d; i++) v.remove(v.size() - 1);
                    t = t.left;
                }
            } else {
                t = t.right;
                if (t == null && m == sum) vv.add(new ArrayList<>(v));
            }
        }
        return vv;
    }
}
