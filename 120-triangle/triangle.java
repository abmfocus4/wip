// https://www.youtube.com/watch?v=OM1MTokvxs4&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=7&ab_channel=NeetCode
// O(n) space
// O(n^2) time
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // corner case
        if(triangle == null || triangle.size() == 0) return 0;
        
        // M[i] represents the min total from bottom to current position
        // copy the last row in triangle to M
        int m = triangle.size(); // number of rows in triangle
        int n = triangle.get(m - 1).size(); // size of the last level
        int[] M = new int[n]; 
        for(int i = 0; i < n; i++){
            M[i] = triangle.get(m - 1).get(i); // since we atleast have to store the bottom level
        }
        
        // induction rule
        // M[i] = min(M[i], M[i + 1]) + curVal
        for(int i = n - 2; i >= 0; i--){ // start from the second last level
            List<Integer> cur = triangle.get(i); // get the current level
            for(int j = 0; j < cur.size(); j++){ // for each element in the level
                M[j] = Math.min(M[j], M[j + 1]) + cur.get(j); // add previous min to current node value
            }
        }
        
        return M[0]; // return the value of top level
    }
}

// without extra space by modifying the input

//  public int minimumTotal(List<List<Integer>> triangle) {
// 		if(triangle.size() == 0)
// 			return 0;
		
// 		for (int i=triangle.size() - 2; i>=0; i--) {
// 			for (int j=0; j<=i; j++) {
// 				List<Integer> nextRow = triangle.get(i+1);
// 				int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
// 				triangle.get(i).set(j, sum);
// 			}
// 		}
// 		return triangle.get(0).get(0);
// 	}