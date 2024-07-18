class HitCounter {

    // Idea 1: use treemap : navigable map interface
    // https://leetcode.com/problems/design-hit-counter/editorial/comments/998191
    // Idea failed: don't need logn search since the qs says that timestamps are
    // recieved in monotonically increasing order


    // read editorial for explanation and time complexity
    Queue<Integer> q;

    public HitCounter() {
        this.q = new LinkedList();
    }

    public void hit(int timestamp) {
        while (q.isEmpty() == false && q.peek() <= timestamp - 300) {
            q.poll();
        }
        q.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (q.isEmpty() == false && q.peek() <= timestamp - 300) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */