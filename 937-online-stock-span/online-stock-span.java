// https://leetcode.com/problems/online-stock-span/solutions/640358/java-solution-with-visualization-and-easy-explained
class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack();
    }
    
    public int next(int price) {
        int span = 1;
        while (stack.isEmpty() == false && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        stack.push(new int[] {price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */