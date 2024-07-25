class HitCounter {
    private int total;
    private Deque<Pair<Integer, Integer>> hits; 

    public HitCounter() {
        this.total = 0;
        this.hits = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public void hit(int timestamp) {
        if (this.hits.isEmpty() || this.hits.peekLast().getKey() != timestamp) {
            this.hits.add(new Pair<Integer, Integer>(timestamp, 1));
        } else {
            int prevCount = this.hits.peekLast().getValue();
            this.hits.pollLast();
            this.hits.addLast(new Pair<Integer, Integer>(timestamp, prevCount + 1));
        }
        this.total++;
    }
    
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty() && hits.peekFirst().getKey() <= timestamp - 300) {
            this.total -= this.hits.peekFirst().getValue();
            this.hits.pollFirst();
        }
        return this.total;
    }
}