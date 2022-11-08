/*Solution: Iterative
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int countSegments(String s) {
        int seg = 0;
        for (int i = 0; i < s.length(); i++) {
            //handle the edge case by count the first char not ' '
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                seg++;
            }
        }
        return seg;
    }
}
