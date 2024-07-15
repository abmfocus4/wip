class Solution {
    
    class MorrisIterator implements Iterator<Integer>{
        private TreeNode current;
        private TreeNode pre;
        public MorrisIterator(TreeNode root){
            current = root;
            pre = null;
        }
        public boolean hasNext(){
            return current != null;
        } 
        
        public Integer next(){
            Integer val = null;
            while (current != null){
                if(current.left == null){
                    val = current.val;
                    current = current.right;
                    break;
                } else {
                    pre = current.left;
                    while(pre.right != null && pre.right != current){
                        pre = pre.right;
                    }
                    if(pre.right == null){
                        pre.right = current;
                        current = current.left;
                    } else {
                        pre.right = null;
                        val = current.val;
                        current = current.right;
                        break;
                    }
                }
            }
            return val;
        }
    } 
    
    public int getMinimumDifference(TreeNode root) {
        MorrisIterator mi = new MorrisIterator(root);
        Integer prev = mi.next();
        int minDiff = Integer.MAX_VALUE;
        while(mi.hasNext()){
            int curr = mi.next();
            minDiff = Math.min(minDiff, (curr - prev));
            prev = curr;
        }
        return minDiff;
            
    }
}