/*Solution: Using Stack with two pointer, one pointer operation means the last operation
* we saw in the string, another pointer for counting the num of curchar
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        char operation = '+';
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            if (Character.isDigit(curS)) {
                cur = cur * 10 + (curS - '0');
            }
            //here is important, we must to check if i is the last element of s
            if (!Character.isDigit(curS) && !Character.isWhitespace(curS) || i == s.length() - 1) {
                //we set later the operation to curS, since we need at least one num in stack to * or /
                if (operation == '+') {
                    stack.push(cur);
                } else if (operation == '-') {
                    stack.push(-cur);
                } else if (operation == '*') {
                    stack.push(stack.pop() * cur);
                } else if (operation == '/') {
                    stack.push(stack.pop() / cur);
                }
                cur = 0;
                operation = curS;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}