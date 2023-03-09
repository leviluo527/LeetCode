/*Solution: Use i pointer to count
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 &&s.charAt(i) == ' ') {
            i--;
        }
        int res = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            res++;
        }
        return res;
    }
}