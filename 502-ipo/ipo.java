// https://www.youtube.com/watch?v=1IUzNJ6TPEM&list=TLPQMDcwNjIwMjSq9lKrG3yYNQ&index=6&ab_channel=NeetCodeIO
public class Solution {
    // TC: k * log(n) * 2
    // SC: O(n)
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // min heap
        PriorityQueue<Integer> pqPro = new PriorityQueue<>((a, b) -> (b - a)); // max heap
        
        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[] {Capital[i], Profits[i]}); // we will have all these to choose from
        }
        
        while (k-- > 0) {
            while (pqCap.isEmpty() == false && pqCap.peek()[0] <= W) { 
                // if capital is less than w, then we can pick it as a contender for profit
                pqPro.add(pqCap.poll()[1]); 
                // we only need profit, capitable was just used for heap sorting
            }
            
            if (pqPro.isEmpty()) break;
            
            W += pqPro.poll();
        }
        
        return W;
    }
}