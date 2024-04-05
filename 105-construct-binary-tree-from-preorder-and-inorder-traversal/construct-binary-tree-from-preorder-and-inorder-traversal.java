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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // use helper function to return node of tree
        // use preorder arr for finding root
        // inorder arr for finding left and right subtree
        // leaf nodes for null can be found if boundary checks

        // optimization: use hash table to make algorith linear time
        // question says no duplicates so no checking required = O(n^2) time and O(n) [recursion] space to O(n) time and space
        HashMap<Integer, Integer> inMap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return helper(0, 0, inorder.length - 1, preorder, inorder, inMap); // pass InMap
        
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, HashMap<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null; //leaf nodes
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRootIndex = inMap.get(root.val); // get root index from inMap

        int numLeftNodes = inRootIndex - inStart;

        root.left = helper(preStart + 1, inStart, inRootIndex - 1, preorder, inorder, inMap); // pass InMap
        root.right = helper(preStart + 1 + numLeftNodes, inRootIndex + 1, inEnd, preorder, inorder, inMap); // passInMap
        return root;
    }
}