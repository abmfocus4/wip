class Solution {
    public int pivotIndex(int[] nums) {
        
        // Initialization:
        // Left hand side be empty, and
        // Right hand side holds all weights.
        int totalWeightOnLeft = 0;
        int totalWeightOnRight = 0;

        // sum all for right weight
        for (int i = 0; i < nums.length; i++)
            totalWeightOnRight += nums[i];
        
        for( int i = 0 ; i < nums.length ; i++ ){
            int curWeight = nums[i];
            totalWeightOnRight -= curWeight;
            if(totalWeightOnLeft == totalWeightOnRight){
                // balance is met on both sides
                return i;
            }
            totalWeightOnLeft  += curWeight;
        }
        
        return -1;
    }
}