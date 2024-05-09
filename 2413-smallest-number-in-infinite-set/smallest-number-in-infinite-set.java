// https://leetcode.com/problems/smallest-number-in-infinite-set/solutions/3452140/easy-solution-explained-with-dry-run-minheap-counter-beginner-friendly
class SmallestInfiniteSet {
    int min;
    PriorityQueue<Integer> heap;
    boolean[] isBucketEmpty;

    public SmallestInfiniteSet() {
        min = 1;
        heap = new PriorityQueue();
        isBucketEmpty = new boolean[1001];
    }
    
    public int popSmallest() {
        if (heap.isEmpty() == false) {
            isBucketEmpty[heap.peek()] = true;
            return heap.poll();
        }
        isBucketEmpty[min] = true;
        min++; // popped the min element so min is next element
        return min-1; // current min
    }
    
    public void addBack(int num) {
        // heap.contains takes O(n) time
        if (num < min && isBucketEmpty[num] == true) {
            heap.add(num);
            isBucketEmpty[num] = false;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */