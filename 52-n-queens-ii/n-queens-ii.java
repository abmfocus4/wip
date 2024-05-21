// only returning number of distinct solutions 
// not actual solutions like N-Queens
class Solution {
	public int totalNQueens(int n) {
        return backtrack(0, 0, 0, 0, n); // diff
    }
    
    private int backtrack(int row, int cols, int diags, int antiDiags, int N) {
		// If we're at row N, we've finished placing all N queens. Therefore, we've reached a new valid position.
        if (row == N) return 1; // diff
        
        int total = 0; // diff
        for (int col=0; col<N; col++) {
            int diag = row - col + N;
            int antiDiag = row + col;
            
			// Check if it's possible to place a Queen at this point
            if ((cols & (1 << col)) != 0 || (diags & (1 << diag)) != 0 || (antiDiags & (1 << antiDiag)) != 0) continue;
            
			// If so, apply changes to the columns and diagonals
            cols |= 1 << col;
            diags |= 1 << diag;
            antiDiags |= 1 << antiDiag;
            
			// DIFF: Continue to the next row
            total += backtrack(row + 1, cols, diags, antiDiags, N);
            
			// Undo changes and try another position
            cols ^= 1 << col;
            diags ^= 1 << diag;
            antiDiags ^= 1 << antiDiag;
        }
        
        return total;
    }
}