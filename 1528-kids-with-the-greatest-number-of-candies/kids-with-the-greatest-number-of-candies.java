// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/solutions/3425582/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Arrays.stream(candies).max().getAsInt();
        
        List<Boolean> result = new ArrayList<>();
        
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}