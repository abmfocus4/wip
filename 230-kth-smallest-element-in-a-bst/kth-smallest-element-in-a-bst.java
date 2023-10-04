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
 // If you have to frequently find kth elements
class Solution {
    public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    int[] kthArr = new int[k];
    int count = 0;
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);    
             root = root.left;   
         } 
         root = stack.pop();
         kthArr[count++] = root.val;
         if(count == k) break;
         root = root.right;
     }
     return kthArr[k-1];
    }
}