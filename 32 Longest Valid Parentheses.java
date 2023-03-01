/*Solution: Use Stack
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        //Since we need to count length, therefore, we need to insert -1 first
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //first, we should pop the last '(' index
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                max = Math.max(i - stack.peek(), max);
            }
        }
        return max;
    }
}