// Ref : https://leetcode.com/problems/contains-duplicate/solutions/2459020/very-easy-100-fully-explained-c-java-python-javascript-python3-creating-set/?envType=list&envId=pxw54vnt
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // single iteration of nums
        // add each to hash set and check if it contains
        // if it contains return true
        // else nothing
        // after loop exits return false
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        
        return false;
    }
}