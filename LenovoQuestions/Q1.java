// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

// Example 1:

// Input:nums = [1,1,1], k = 2
// Output: 2

//Algorithm

// The idea behind this approach is as follows: If the cumulative sum(represented by sum[i]sum[i] for sum up to i^{th} index) up to two indices is the same, the sum of the elements lying in between those indices is zero. Extending the same thought further, if the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i] - sum[j] = ksum[i]−sum[j]=k, the sum of elements lying between indices i and j is k.

// Based on these thoughts, we make use of a hashmap mapmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs. We store the data in the form: (sum_i, no. of occurrences of sum_i). We traverse over the array numsnums and keep on finding the cumulative sum. Every time we encounter a new sum, we make a new entry in the hashmap corresponding to that sum. If the same sum occurs again, we increment the count corresponding to that sum in the hashmap. Further, for every sum encountered, we also determine the number of times the sum sum-k has occurred already, since it will determine the number of times a subarray with sum k has occurred up to the current index. We increment the countcount by the same amount.

// After the complete array has been traversed, the countcount gives the required result.


public class Q1 {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap <Integer, Integer> ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}