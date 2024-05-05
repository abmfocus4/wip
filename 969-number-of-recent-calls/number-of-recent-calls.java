// https://www.youtube.com/watch?v=HlmNEfcgyjM&ab_channel=NickWhite

// different data structures - https://leetcode.com/problems/number-of-recent-calls/solutions/189239/java-python-3-five-solutions-treemap-treeset-arraylist-queue-circular-list


class RecentCounter {
    Queue<Integer> q;    
    public RecentCounter() {
        this.q = new LinkedList();
    }
    
    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */