// https://leetcode.com/problems/smallest-number-in-infinite-set/solutions/3452140/easy-solution-explained-with-dry-run-minheap-counter-beginner-friendly
class SmallestInfiniteSet {
    int min;
    PriorityQueue<Integer> heap;

    public SmallestInfiniteSet() {
        min = 1;
        heap = new PriorityQueue();
    }
    
    public int popSmallest() {
        if (heap.isEmpty() == false) {
            return heap.poll();
        }
        min++; // popped the min element so min is next element
        return min-1; // current min
    }
    
    public void addBack(int num) {
        if (num < min && heap.contains(num) == false) {
            heap.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */