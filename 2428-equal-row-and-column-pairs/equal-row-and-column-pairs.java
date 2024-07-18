class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append("#");
            }
            String rowStr = sb.toString();
            if (map.containsKey(rowStr) == false) {
                map.put(rowStr, 0);
            }
            map.put(rowStr, map.get(rowStr) + 1);
        }
        
        int pairs = 0;
        for (int j = 0; j < n; j++) {
            sb.setLength(0);
            for (int i = 0; i < m; i++) {
                sb.append(grid[i][j]).append("#");
            }
            String colStr = sb.toString();
            pairs += map.getOrDefault(colStr, 0);            
        }

        return pairs;
    }
}