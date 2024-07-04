/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<Pair<TreeNode, Integer>> q = new LinkedList(); // int[0] val; int[1] index

        q.add(new Pair(root, 0)); // start index at 1 and level at 0

        int maxWidth = 0;

        while(q.isEmpty() == false) {
            int levelSize = q.size();

            int leftMostIdx = q.peekFirst().getValue();
            int rightMostIdx = q.peekLast().getValue();
            maxWidth = Math.max(maxWidth, rightMostIdx - leftMostIdx + 1);

            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> cur = q.pollFirst();
                int curIdx = cur.getValue();
                TreeNode curNode = cur.getKey();

                if (curNode.left != null) {
                    q.add(new Pair(curNode.left, 2*curIdx));
                }

                if (curNode.right != null) {
                    q.add(new Pair(curNode.right, 2*curIdx + 1));
                }
            }
        }

        return maxWidth;

    }
}