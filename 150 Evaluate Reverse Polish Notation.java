/*Solution: Stack
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int i = stack.pollLast();
                int j = stack.pollLast();
                stack.offerLast(i + j);
            } else if (s.equals("-")) {
                int j = stack.pollLast();
                int i = stack.pollLast();
                stack.offerLast(i - j);
            } else if (s.equals("*")) {
                int i = stack.pollLast();
                int j = stack.pollLast();
                stack.offerLast(i * j);
            } else if (s.equals("/")) {
                int j = stack.pollLast();
                int i = stack.pollLast();
                stack.offerLast(i / j);
            } else {
                stack.offerLast(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}