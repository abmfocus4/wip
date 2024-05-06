class Solution {
    // https://www.youtube.com/watch?v=5EHbuQUBQh0&ab_channel=EricProgramming
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int N = temperatures.length;
        int[] map = new int[N];
        Arrays.fill(map, 0);

        for (int i = 0; i < N; i++) {
            while (stack.isEmpty() == false && temperatures[stack.peek()] < temperatures[i]) {
                Integer topIndex = stack.pop();
                int diff = i - topIndex;
                map[topIndex] = diff;
            }
            stack.push(i);
        }

        // not need, already 0
        // while(stack.isEmpty() == false) {
        //     Integer topIndex = stack.pop();
        //     map[topIndex] = 0;
        // }

        return map;
    }
}