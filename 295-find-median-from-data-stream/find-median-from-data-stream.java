class MedianFinder {
    // min heap
    PriorityQueue<Integer> minHeap;
    // max heap
    PriorityQueue<Integer> maxHeap;
    // size
    int size;


    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> b-a);
        this.size = 0;
        
    }
    
    public void addNum(int num) {
        // size increase
        size++;

        // add to one of the heaps
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // adjust heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (size % 2 == 0) { // even
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else { // odd
            return (double)maxHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */