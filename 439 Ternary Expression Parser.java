/*Solution: Use Stack to traverse from right to left
* Time: O(N)
* Space: O(N / 2)
*/
class Solution {
    public String parseTernary(String expression) {
        //first: create a stack to hold characters
        Stack<Character> s = new ArrayDeque<>();
        //set the i pointer to the right most
        int i = expression.length() - 1;
        char res = ' ';
        while (i >= 0) {
            //while we have not meet the ? condition, we just need to push
            //element in the stack
            if (expression.charAt(i) != '?') {
                //when we see a :, we could just ignore it
                if (expression.charAt(i) != ':') {
                    s.push(expression.charAt(i));
                }
            } else {
                //Since curChar is i, therefore, we need see i - 1 is T or F
                i--;
                //Every time we pop out two element, then we save the frist
                //or the second element in the stack
                if (expression.charAt(i) == 'T') {
                    res = s.pop();
                    s.pop();
                    s.push(res);
                } else {
                    s.pop();
                    res = s.pop();
                    s.push(res);
                }
            }
            i--;
        }
        //String.valueOf to return a String
        return String.valueOf(res);
    }
}
