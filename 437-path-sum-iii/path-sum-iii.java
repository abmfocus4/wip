class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFromNode(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int pathSumFromNode(TreeNode node, long sum) { // make sum long
        int result = 0;
        
        if (node == null) return 0;
        if (node.val == sum) {
            result += 1;
        }
        
        result += pathSumFromNode(node.left, sum - node.val);
        result += pathSumFromNode(node.right, sum - node.val);
        
        return result;
    }
}