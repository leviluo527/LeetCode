/*Solution: Use Monotonic Stack
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int len = heights.length;
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int curWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, curWidth * curHeight);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int curHeight = heights[stack.pop()];
            int curWidth = len - stack.peek() - 1;
            maxArea = Math.max(maxArea, curWidth * curHeight);
        }
        return maxArea;
    }
}