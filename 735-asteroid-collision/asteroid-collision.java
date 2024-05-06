// https://leetcode.com/problems/asteroid-collision/solutions/109694/java-c-clean-code/comments/120966
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // ++ -- +- -+

        if (asteroids == null) return null;
        if (asteroids.length <= 1) return asteroids;

        Stack<Integer> stack = new Stack();

        for (int asteroid : asteroids) {
            if (asteroid > 0) { // ++, -+
                stack.push(asteroid);
            } else { // --, +- (collision)
                while (stack.isEmpty() == false && stack.peek() > 0 && -asteroid > stack.peek()) {
                    stack.pop(); // +-
                }
                if (stack.isEmpty() || stack.peek() < 0) { // - or --
                    stack.push(asteroid);
                } else if (stack.peek() == -asteroid) { // +- (but equal)
                    stack.pop(); // at end because once asteroid explodes no power to continue
                }
            }
        }

        return stack.stream().mapToInt(i->i).toArray();
    }
}