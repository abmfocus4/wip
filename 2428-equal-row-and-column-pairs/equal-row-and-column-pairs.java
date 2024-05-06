class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> map = new HashMap(); // row string, frequency
        
        int m = grid.length;
        int n = grid[0].length;
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            sb.setLength(0);
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
                sb.append("#");
            }
            String row_str = sb.toString();
            if (!map.containsKey(row_str)) {
                map.put(row_str, 0);
            }
            map.put(row_str, map.get(row_str)+1);
        }
        
        int pairs = 0;
        for (int j = 0; j < n; j++) {
            sb.setLength(0);
            for (int i = 0; i < m; i++) {
                sb.append(grid[i][j]);
                sb.append("#");
            }
            String col_str = sb.toString();
            if (map.containsKey(col_str)) {
                pairs += map.get(col_str);
            }
        }
        
        return pairs;
    }
}