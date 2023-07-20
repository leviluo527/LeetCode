/*Solution: Use a stack as add '()'
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        while (j < asteroids.length) {
            int cur = asteroids[j];
            if (stack.isEmpty()) {
                stack.add(cur);
                j++;
            } else {
                if (cur > 0) {
                    stack.add(cur);
                    j++;
                } else {
                    if (stack.peek() < 0) {
                        stack.add(cur);
                        j++;
                    } else {
                        if (stack.peek() == Math.abs(cur)) {
                            stack.pop();
                            j++;
                        } else if (stack.peek() < Math.abs(cur)) {
                            stack.pop();
                        } else {
                            j++;
                        }
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        int k = stack.size() - 1;
        while (k >= 0) {
            res[k--] = stack.pop();
        }
        return res;
    }
}