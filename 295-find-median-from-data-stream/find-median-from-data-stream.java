// Follow-ups:
// https://leetcode.com/problems/find-median-from-data-stream/description/comments/1564564
// https://leetcode.com/problems/find-median-from-data-stream/description/comments/1567590


// Code Ref: https://www.youtube.com/watch?v=JNKdfHmnMSg
class MedianFinder {
    // declare heaps - priority queue
    // max heap
    // min heap
    Queue<Integer> maxHeap; // only touching maxHeap
    Queue<Integer> minHeap;
    int size;

    public MedianFinder() {
        // init
        this.maxHeap = new PriorityQueue<>((a, b) -> (b-a));
        this.minHeap = new PriorityQueue<>();
        this.size = 0; 
    }
    
    public void addNum(int num) {
        // increase size
        size++;

        // add onto right heap
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // balance heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // if size is off then pop from max heap
        if (size % 2 != 0) {
            return (double) maxHeap.peek();
        } else { // if size is even then take avg of max and min heap roots
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */