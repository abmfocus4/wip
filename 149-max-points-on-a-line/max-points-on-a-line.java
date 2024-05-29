// time comp - O(n2) & space comp - O(n)
// https://www.youtube.com/watch?v=AzER0wuL0QY&list=TLPQMjYwNTIwMjRZnxFRIBCHUQ&index=11&ab_channel=codestorywithMIK
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        int totalPoints = 0;
        int n = points.length;
        if (n <= 1) {
            return n;
        }
        for (int i = 0; i < n; i++) {
            int max_count = 0;
            Map<Pair<Integer, Integer>, Integer> map = new HashMap(); // dx,dy slope and freq
            // use map.clear() and declare map outside instead
            for (int j = i+1; j < n; j++) {
                // x2 - x1
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];

                int gcd = gcd(deltaX, deltaY); 
                int dx = deltaX/gcd;
                int dy = deltaY/gcd;
                Pair slope = new Pair(dy, dx);

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max_count = Math.max(max_count, map.get(slope));
            }
            totalPoints = Math.max(max_count + 1, totalPoints); // add the ith point too
            
        }

        return totalPoints;
    }

    private int gcd (int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }
}