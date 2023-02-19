/*Solution: skip all the blank space, then check the sign
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int res = 0;
        int ind = 0;
        int n = s.length();
        while (ind < n && s.charAt(ind) == ' ') {
            ind++;
        }

        if (ind < n && s.charAt(ind) == '+') {
            sign = 1;
            ind++;
        } else if (ind < n && s.charAt(ind) == '-') {
            sign = -1;
            ind++;
        }

        while (ind < n && Character.isDigit(s.charAt(ind))) {
            int digit = s.charAt(ind) - '0';

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10) && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            ind++;
        }

        return sign * res;
    }
}