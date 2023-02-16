/*Solution: Since we will always looking back, therefore, use a stack
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (cur == ')') {
                    if (stack.peek() != '(') {
                        return false;
                    } 
                } else if (cur == '}') {
                    if (stack.peek() != '{') {
                        return false;
                    } 
                } else {
                    if (stack.peek() != '[') {
                        return false;
                    }
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}